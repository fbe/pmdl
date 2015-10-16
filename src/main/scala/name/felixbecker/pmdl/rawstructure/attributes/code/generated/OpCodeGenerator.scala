package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.io.{PrintWriter, File}

import org.jsoup.Jsoup

import scala.collection.JavaConversions._

/**
 * Created by becker on 10/14/15.
 */

sealed case class OpCode(name: String, byteValue: String, parameters: List[String])

private[code] object OpCodeGenerator extends App {

  val document = Jsoup.connect("https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html").get()
  // class section-execution
  val sectionExecutions = document.getElementsByClass("section-execution")

  // (maybe fix me) tail because of mnemonic, fix it, other format parse possible
  val opCodes = sectionExecutions.tail.flatMap { element =>
    val opcode = element.select("h3").head.text()

    /* Literallayout eg.
      checkcast
      indexbyte1
      indexbyte2
     */

    /*
   Forms
   checkcast = 192 (0xc0)
    */
    val parameters = element.select(".literallayout em").tail.map(_.text()).toList

    val opCodeDefinitions = element.getElementsByAttributeValue("title", "Forms").select(".norm").map(_.text())
    val opcodePattern = """^([^ ]+) = ([0-9]+) \((0x[^)]+)\)""".r

    val opCodeDefinitionsParsed = opCodeDefinitions.map {
        case opcodePattern(opcodeName, opcodeDecValue, byteValue) => OpCode(opcodeName, byteValue, parameters)
    }.toList

    opCodeDefinitionsParsed
  }.toList


  opCodes.foreach(println)
  println(opCodes.size)

  val outputDirectoryPath = new File(getClass.getProtectionDomain.getCodeSource.getLocation.toURI).getAbsolutePath + "/" + getClass.getPackage.getName.replace(".", "/")
  println(outputDirectoryPath)

  val rendered = opCodes.foreach(opCode => {
    val fileName = s"${opCode.name.toUpperCase}.scala"
    println(s"Rendering to File: $outputDirectoryPath/$fileName")
    val rendered = generateOpCode(opCode.byteValue, opCode.name, opCode.parameters)
    new PrintWriter(new File(outputDirectoryPath + "/" + fileName)).write(rendered)
  })



  def generateOpCode(byte: String, name: String, parameter: List[String]): String = {
    val template = s"""
    |package name.felixbecker.pmdl.rawstructure.attributes.code.generated
    |
    |import java.nio.ByteBuffer
    |
    |object $name extends OpcodeFromBytes[$name] {
    |
    |  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = $name(${parameter.map(_ => "byteBuffer.get()").mkString(", ")})
    |
    |  override def byteValue: Byte = $byte.toByte
    |}
    |
    |case class $name(${parameter.map(_ + ": Byte").mkString(", ")}) extends Opcode
    |
  """.stripMargin
    template
  }
}

