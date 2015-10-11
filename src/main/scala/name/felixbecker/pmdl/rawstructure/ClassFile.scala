package name.felixbecker.pmdl.rawstructure

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.attributes.AttributeInfo
import name.felixbecker.pmdl.rawstructure.constantpool.{CPInfo, ConstantPoolParser}
import name.felixbecker.pmdl.rawstructure.fields.{FieldInfo, FieldInfoParser}
import name.felixbecker.pmdl.rawstructure.methods.{MethodInfo, MethodInfoParser}

// Representation of a raw class file, defined in https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html

object ClassFile {

  def fromByteBuffer(bytes: ByteBuffer) = {
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
    val cpInfos: ConstantPool = new ConstantPoolParser(constantPoolCount.toShort).parse(bytes)
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
    val attributes = AttributeInfo.fromByteBuffer(bytes, attributesCount)

    assert(bytes.remaining() == 0)

    ClassFile(magicNumber, minorVersion, majorVersion, constantPoolCount, cpInfos, accessFlags, thisClass, superClass, interfacesCount, interfaces, fieldCount, fields, methodsCount, methods, attributesCount, attributes)
  }

}

case class ClassFile(
                      magicNumber: Int,
                      minorVersion: Short,
                      majorVersion: Short,
                      constantPoolCount: Short,
                      cpInfos: Map[Short, CPInfo],
                      accessFlags: List[AccessFlag],
                      thisClass: Short,
                      superClass: Short,
                      interfacesCount:Short,
                      interfaces: List[Short],
                      fieldCount: Short,
                      fields: List[FieldInfo],
                      methodsCount: Short,
                      methods: List[MethodInfo],
                      attributesCount: Short,
                      attributes: List[AttributeInfo]


                      ) extends Traversable[Any] {



  override def toString: String = {
    val magicNumberAsString: String = "0x%02X".format(magicNumber)
    s"""
       | Magic number: $magicNumberAsString
       | Version: $majorVersion.$minorVersion
       | Constant pool count: $constantPoolCount
       | Access Flags: ${accessFlags.map(_.name).mkString(", ")}
       | This class: $thisClass (cp index)
       | Super class: $superClass (cp index)
       | Interfaces count: $interfacesCount
       | Field count: $fieldCount
       | Method count: $methodsCount
       | Attributes count: $attributesCount
       | =============================> Constant Pool ($constantPoolCount (-1)) <=============================
       | ${cpInfos.map{case (k,v) => v}.toList.sortBy(c => c.cpIndex).mkString("\n ")}
       | =============================> Interfaces ($interfacesCount) <=============================
       | ${interfaces.map(x => s"Constant pool reference: $x").mkString("\n ")}     // TODO Own CP case class
       | =============================> Fields ($fieldCount) <=============================
       | ${fields.mkString("\n ")}
       | =============================> Methods ($methodsCount) <=============================
       | ${methods.mkString("\n ")}
       | =============================> Attributes ($attributesCount) <=============================
       | ${attributes.mkString("\n ")}
       |
     """.stripMargin
  }

  override def foreach[U](f: (Any) => U): Unit = {
    f(magicNumber)
    f(minorVersion)
    f(majorVersion)
    f(constantPoolCount)
    cpInfos.foreach(f)
    f(accessFlags)
    f(superClass)
    f(interfacesCount)
    interfaces.foreach(f)
    f(fieldCount)
    fields.foreach(f)
    f(methodsCount)
    methods.foreach(f)
    f(attributesCount)
    attributes.foreach(f)
  }
}

