import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.io.Source
def generateOpCode(byte: String, name: String, parameter: String*): Unit = {
val template = s"""
  |package name.felixbecker.pmdl.rawstructure.attributes.code
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

  val path = s"/home/becker/git/JBCP/src/main/scala/name/felixbecker/pmdl/rawstructure/attributes/code/$name.scala"
  Files.write(Paths.get(path), template.getBytes(StandardCharsets.UTF_8))
}
generateOpCode("0x12", "LDC", "index")
generateOpCode("0x10", "BIPUSH", "byte")
generateOpCode("0x03", "ICONST0")
generateOpCode("0x2b", "ALOAD1")
generateOpCode("0xb1", "RETURN")
generateOpCode("0xb2", "GETSTATIC", "index1", "index2")
generateOpCode("0xb6", "INVOKEVIRTUAL", "index1", "index2")
generateOpCode("0xb4", "GETFIELD", "index1", "index2")
generateOpCode("0xb9", "INVOKEINTERFACE", "index1", "index2", "count", "zeroByte")
generateOpCode("0xa7", "GOTO", "branchbyte1", "branchbyte2")
generateOpCode("0x4c", "ASTORE1")
generateOpCode("0x59", "DUP")
generateOpCode("0xbf", "ATHROW")
generateOpCode("0xb0", "ARETURN")
generateOpCode("0x05", "ICONST2")
generateOpCode("0x70", "IREM")
generateOpCode("0xbb", "NEW", "indexbyte1", "indexbyte2")
generateOpCode("0x9a", "IFNE", "branchbyte1", "branchbyte2")
