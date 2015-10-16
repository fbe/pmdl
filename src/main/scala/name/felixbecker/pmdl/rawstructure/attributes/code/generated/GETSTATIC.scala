
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object GETSTATIC extends OpcodeFromBytes[GETSTATIC] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = GETSTATIC(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb2.toByte
}

case class GETSTATIC(indexbyte1: Byte, indexbyte2: Byte) extends Opcode

  