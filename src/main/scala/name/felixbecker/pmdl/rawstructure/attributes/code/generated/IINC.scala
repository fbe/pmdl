package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IINC extends OpcodeFromBytes[IINC] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IINC(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x84.toByte
}

case class IINC(index: Byte, const: Byte) extends Opcode
