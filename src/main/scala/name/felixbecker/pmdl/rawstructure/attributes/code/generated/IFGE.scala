package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFGE extends OpcodeFromBytes[IFGE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFGE(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x9c.toByte
}

case class IFGE(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
