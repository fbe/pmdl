
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object PUTSTATIC extends OpcodeFromBytes[PUTSTATIC] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = PUTSTATIC(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb3.toByte
}

case class PUTSTATIC(indexbyte1: Byte, indexbyte2: Byte) extends Opcode

  