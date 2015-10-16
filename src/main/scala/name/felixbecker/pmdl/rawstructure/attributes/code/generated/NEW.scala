
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object NEW extends OpcodeFromBytes[NEW] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = NEW(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xbb.toByte
}

case class NEW(indexbyte1: Byte, indexbyte2: Byte) extends Opcode

  