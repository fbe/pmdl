
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object LDC extends OpcodeFromBytes[LDC] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LDC(byteBuffer.get())

  override def byteValue: Byte = 0x12.toByte
}

case class LDC(index: Byte) extends Opcode

