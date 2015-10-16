
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LLOAD extends OpcodeFromBytes[LLOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LLOAD(byteBuffer.get())

  override def byteValue: Byte = 0x16.toByte
}

case class LLOAD(index: Byte) extends Opcode

  