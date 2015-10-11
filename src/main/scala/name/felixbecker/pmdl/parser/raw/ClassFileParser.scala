package name.felixbecker.pmdl.parser.raw

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.model.{FieldInfo, ClassFile}

object ClassFileParser extends RawParser[ClassFile] {


  override def parse(bytes: ByteBuffer): ClassFile = {

    val magicNumber = bytes.getInt()

    if(magicNumber != 0xCAFEBABE){
      throw new RuntimeException("File doesn't start with 0xCAFEBABE - isn't a java class file!")
    }

    val minorVersion = bytes.getShort()
    val majorVersion = bytes.getShort()

    /*if(majorVersion < 52){
      System.out.println("Parsing classes with major_level < 52 not implemented yet. Skipping")
      throw new RuntimeException("Parsing classes with major_level < 52 not implemented yet. Skipping")
    }*/

    val constantPoolCount = bytes.getShort()
    val cpInfos: List[CPInfo] = new ConstantPoolParser((constantPoolCount-1).toShort).parse(bytes)
    val accessFlags: List[AccessFlag] = AccessFlags.shortToAccessFlags(bytes.getShort(), AccessFlags.ClassAccessFlags)
    val thisClass = bytes.getShort()
    val superClass = bytes.getShort()
    val interfacesCount = bytes.getShort()

    // TODO extract me
    val interfaces = (1 to interfacesCount).map { _ =>
      val constantPoolIdxForIface = bytes.getShort
      constantPoolIdxForIface
    }.toList

    val fieldCount = bytes.getShort()

    val fields: List[FieldInfo] = new FieldInfoParser(fieldCount).parse(bytes)

    val methodsCount = bytes.getShort()

    val methods: List[MethodInfo] = new MethodInfoParser(methodsCount).parse(bytes)

    val attributesCount = bytes.getShort()
    val attributes = new AttributeParser(attributesCount).parse(bytes)

    assert(bytes.remaining() == 0)

    ClassFile(magicNumber, minorVersion, majorVersion, constantPoolCount, cpInfos, accessFlags, thisClass, superClass, interfacesCount, interfaces, fieldCount, fields, methodsCount, methods, attributesCount, attributes)

  }
}