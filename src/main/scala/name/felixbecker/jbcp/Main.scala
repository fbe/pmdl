package name.felixbecker.jbcp

import java.nio.ByteBuffer
import java.nio.file.{Paths, Files}



object CPInfo {

  val ClassTag = 7
  val Fieldref = 9
  val Methodref = 10
  val InterfaceMethodRef = 11
  val String = 8
  val Integer = 3
  val Float = 4
  val Long = 5
  val Double = 6
  val NameAndType = 12
  val Utf8 = 1
  val MethodHandle = 15
  val MethodType = 16
  val InvokeDynamic = 18

}

object ClassAccessFlags {
  val ACC_PUBLIC = 0x0001
  val ACC_FINAL = 0x0010
  val ACC_SUPER = 0x0020
  val ACC_INTERFACE = 0x0200
  val ACC_ABSTRACT = 0x0400
  val ACC_SYNTHETIC = 0x1000
  val ACC_ANNOTATION = 0x2000
  val ACC_ENUM = 0x4000
}

object Parser {

  def parse(testClassFile: String = "target/scala-2.11/test-classes/name/felixbecker/jbcp/testassets/TestClass.class"): Unit ={

    val array = Files.readAllBytes(Paths.get(testClassFile))

    println(s"Loaded ${array.size} bytes from File $testClassFile")

    val bytes = ByteBuffer.wrap(array)

    val cafebabe = bytes.getInt

    if(cafebabe != 0xCAFEBABE){
      throw new RuntimeException("File doesn't start with 0xCAFEBABE - isn't a java class file!")
    }

    val minor_version = bytes.getShort
    val major_version = bytes.getShort


    println(s"Class version is $major_version.$minor_version")

    if(major_version < 52){
      System.out.println("Parsing classes with major_level < 52 not implemented yet. Skipping")
      return
    }

    val constantPoolCount = bytes.getShort

    ConstantPool.parseCpInfo(bytes, constantPoolCount-1)

    val accessFlags = bytes.getShort
    val thisClass = bytes.getShort
    val superClass = bytes.getShort
    val interfacesCount = bytes.getShort

    println(s"More class info: accessFlags: $accessFlags, thisClass: $thisClass, superClass: $superClass, interfacesCount: $interfacesCount")

    // interfaces

    println("Access flags translated: ")
    print("Abstract: " + ((accessFlags & ClassAccessFlags.ACC_ABSTRACT) > 0))
    print(" Annotation: " + ((accessFlags & ClassAccessFlags.ACC_ANNOTATION) > 0))
    print(" Enum: " + ((accessFlags & ClassAccessFlags.ACC_ENUM) > 0))
    print(" Final: " + ((accessFlags & ClassAccessFlags.ACC_FINAL) > 0))
    print(" Interface: " + ((accessFlags & ClassAccessFlags.ACC_INTERFACE) > 0))
    print(" Public: " + ((accessFlags & ClassAccessFlags.ACC_PUBLIC) > 0))
    print(" Super: " + ((accessFlags & ClassAccessFlags.ACC_SUPER) > 0))
    println(" Synthetic: " + ((accessFlags & ClassAccessFlags.ACC_SYNTHETIC) > 0))

    (1 to interfacesCount).foreach { _ =>
      val constantPoolIdxForIface = bytes.getShort
      println(s"Class is implementing Interface Constpool: $constantPoolIdxForIface")
    }
    println(s"Remaining bytes: ${bytes.remaining()} byte")

    parseFieldInfos(bytes)
  }

  def parseFieldInfos(bytes: ByteBuffer): Unit ={

    val fieldCount = bytes.getShort
    println(s"Fields count: $fieldCount")

    (1 to fieldCount).foreach { _ =>

      // TODO implement me =)

      /*
      field_info {
        u2             access_flags;
        u2             name_index;
        u2             descriptor_index;
        u2             attributes_count;
        attribute_info attributes[attributes_count];
      }
      */

    }
  }
}

object Main extends App {
  //TestClasses.classes.foreach(c => Parser.parse(c))
  Parser.parse()
}
