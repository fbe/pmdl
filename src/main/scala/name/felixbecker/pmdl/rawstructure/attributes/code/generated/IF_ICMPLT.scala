package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ICMPLT extends OpcodeFromBytes[IF_ICMPLT] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ICMPLT(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa1.toByte
}

case class IF_ICMPLT(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
