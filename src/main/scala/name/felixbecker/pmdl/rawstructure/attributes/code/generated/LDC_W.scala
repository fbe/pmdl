package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LDC_W extends OpcodeFromBytes[LDC_W] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LDC_W(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x13.toByte
}

case class LDC_W(indexbyte1: Byte, indexbyte2: Byte) extends Opcode
