package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ACMPNE extends OpcodeFromBytes[IF_ACMPNE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ACMPNE(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa6.toByte
}

case class IF_ACMPNE(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
