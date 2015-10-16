package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object GETFIELD extends OpcodeFromBytes[GETFIELD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = GETFIELD(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb4.toByte
}

case class GETFIELD(indexbyte1: Byte, indexbyte2: Byte) extends Opcode
