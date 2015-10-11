package name.felixbecker.pmdl

import java.nio.ByteBuffer
import java.nio.file.{Paths, Files}

import name.felixbecker.pmdl.parser.raw._
import name.felixbecker.pmdl.rawstructure.ClassFile


object Main extends App {

  def getClassFile(testClassFile: String = "target/scala-2.11/test-classes/name/felixbecker/pmdl/testassets/TestClass.class"): ClassFile ={

    val array = Files.readAllBytes(Paths.get(testClassFile))

    println(s"Loaded ${array.size} bytes from File $testClassFile")

    val bytes = ByteBuffer.wrap(array)

    val rawClassFile = ClassFileParser.parse(bytes)

    rawClassFile
  }

  //val parsedClasses = TestClasses.classes.map(getClassFile)
  //println(s"Parsed classes: ${parsedClasses.size}")
  println(getClassFile())

  //println(parsedClasses.head)

}
