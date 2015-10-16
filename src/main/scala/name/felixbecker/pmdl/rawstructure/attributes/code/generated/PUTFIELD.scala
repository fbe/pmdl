
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object PUTFIELD extends OpcodeFromBytes[PUTFIELD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = PUTFIELD(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb5.toByte
}

case class PUTFIELD(indexbyte1: Byte, indexbyte2: Byte) extends Opcode

  