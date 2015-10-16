package name.felixbecker.pmdl.rawstructure.attributes.code

import java.io.{File, PrintWriter}

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
    var zeroByteCounter = 0
    val parameters = element.select(".literallayout em").tail.map(_.text()).toList.map {
      case param =>
        if(param == "0"){
          zeroByteCounter += 1
          s"zeroByte$zeroByteCounter"
        } else {
          param
        }
    }


    val opCodeDefinitions = element.getElementsByAttributeValue("title", "Forms").select(".norm").map(_.text())
    val opcodePattern = """^([^ ]+) = ([0-9]+) \((0x[^)]+)\)""".r

    val opCodeDefinitionsParsed = opCodeDefinitions.map {
        case opcodePattern(opcodeName, opcodeDecValue, byteValue) => OpCode(opcodeName, byteValue, parameters)
    }.toList

    opCodeDefinitionsParsed
  }.toList


  opCodes.foreach(println)
  println(opCodes.size)

  val outputDirectoryPath = "/home/becker/git/JBCP/src/main/scala/name/felixbecker/pmdl/rawstructure/attributes/code/generated/"
  println(outputDirectoryPath)

  val rendered = opCodes.filter{ o => o.name != "wide" && o.name != "tableswitch" && o.name != "lookupswitch"}.map(opCode => {
    val fileName = s"${opCode.name.toUpperCase}.scala"
    println(s"Rendering to File: $outputDirectoryPath/$fileName")
    val rendered = generateOpCode(opCode.byteValue, opCode.name.toUpperCase, opCode.parameters)
    val pw = new PrintWriter(new File(outputDirectoryPath + "/" + fileName))
    pw.write(rendered)
    pw.close
    opCode.name.toUpperCase()
  })

  println("List of rendered opcode companions:")
  println(rendered.mkString(",\n"))



  def generateOpCode(byte: String, name: String, parameter: List[String]): String = {
    val template = s"""
    |package name.felixbecker.pmdl.rawstructure.attributes.code.generated
    |
    |import java.nio.ByteBuffer
    |import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}
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

