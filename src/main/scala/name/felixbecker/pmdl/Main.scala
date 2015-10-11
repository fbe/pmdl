package name.felixbecker.pmdl

import java.nio.ByteBuffer
import java.nio.file.{Paths, Files}

import name.felixbecker.pmdl.parser.raw._
import name.felixbecker.pmdl.parser.raw.model.ClassFile


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

//URL [jar:file:/home/becker/hybris-platform-4.8/bin/extensions/douglas/lib/pm-api-3.0.jar!/de/douglas/pm/api/pantone/PantoneGetColorForArticleResponse$.class]

object Parser {

  def parse(testClassFile: String = "target/scala-2.11/test-classes/name/felixbecker/pmdl/testassets/TestClass.class"): ClassFile ={

    val array = Files.readAllBytes(Paths.get(testClassFile))

    println(s"Loaded ${array.size} bytes from File $testClassFile")

    val bytes = ByteBuffer.wrap(array)

    val rawClassFile = ClassFileParser.parse(bytes)

    val methodRefs = rawClassFile.collect {
      case methodRef: CPMethodref => methodRef
    }

    val externalInvocations = methodRefs.map { ref =>

      val classTag = rawClassFile.collect { case x @CPClassTag(ref.classIndex, _) => x }.head
      val nameAndType = rawClassFile.collect { case x @CPNameAndType(ref.nameAndType, _, _) => x }.head
      val className = rawClassFile.collect { case CPUTF8(classTag.nameIndex, stringValue) => stringValue }.head
      val methodName = rawClassFile.collect { case CPUTF8(nameAndType.nameIndex, stringValue) => stringValue }.head
      val methodDescriptor = rawClassFile.collect { case CPUTF8(nameAndType.descriptorIndex, stringValue) => stringValue }.head
      //println(s"Ref: $ref => Classtag: $classTag, className: $className NameAndType: $nameAndType, name: $methodName, descriptor: $methodDescriptor - together: $className.$methodName.$methodDescriptor")
      s"$className.$methodName.$methodDescriptor"
    }

    println(externalInvocations)

    // case class CPNameAndType(cpIndex: Short, nameIndex: Short, descriptorIndex: Short) extends CPInfo


    /*
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
*/
    //parseFieldInfos(bytes)

    rawClassFile
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
  Parser.parse().foreach(println)
  //Parser.parse("/home/becker/git/pm/pm-api/target/classes/de/douglas/pm/api/pantone/PantoneGetColorForArticleResponse$.class")
}
