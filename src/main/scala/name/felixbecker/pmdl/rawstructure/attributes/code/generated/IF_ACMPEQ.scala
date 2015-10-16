package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ACMPEQ extends OpcodeFromBytes[IF_ACMPEQ] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ACMPEQ(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa5.toByte
}

case class IF_ACMPEQ(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
