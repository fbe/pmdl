package name.felixbecker.pmdl

import java.nio.ByteBuffer
import java.nio.file.{Paths, Files}

import name.felixbecker.pmdl.parser.raw._
import name.felixbecker.pmdl.parser.raw.model.ClassFile

object Parser {

  def parse(testClassFile: String = "target/scala-2.11/test-classes/name/felixbecker/pmdl/testassets/TestClass.class"): ClassFile ={

    val array = Files.readAllBytes(Paths.get(testClassFile))

    println(s"Loaded ${array.size} bytes from File $testClassFile")

    val bytes = ByteBuffer.wrap(array)

    val rawClassFile = ClassFileParser.parse(bytes)

    rawClassFile
  }

}

object Main extends App {
  //TestClasses.classes.foreach(c => Parser.parse(c))
  println(Parser.parse())
  //Parser.parse("/home/becker/git/pm/pm-api/target/classes/de/douglas/pm/api/pantone/PantoneGetColorForArticleResponse$.class")
}
