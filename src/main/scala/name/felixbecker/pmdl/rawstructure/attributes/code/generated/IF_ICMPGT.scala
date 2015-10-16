package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ICMPGT extends OpcodeFromBytes[IF_ICMPGT] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ICMPGT(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa3.toByte
}

case class IF_ICMPGT(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
