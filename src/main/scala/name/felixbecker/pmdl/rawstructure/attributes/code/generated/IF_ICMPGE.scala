package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ICMPGE extends OpcodeFromBytes[IF_ICMPGE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ICMPGE(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa2.toByte
}

case class IF_ICMPGE(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
