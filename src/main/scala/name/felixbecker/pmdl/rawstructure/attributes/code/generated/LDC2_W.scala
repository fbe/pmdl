
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LDC2_W extends OpcodeFromBytes[LDC2_W] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LDC2_W(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x14.toByte
}

case class LDC2_W(indexbyte1: Byte, indexbyte2: Byte) extends Opcode

  