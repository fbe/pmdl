package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ICMPEQ extends OpcodeFromBytes[IF_ICMPEQ] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ICMPEQ(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x9f.toByte
}

case class IF_ICMPEQ(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
