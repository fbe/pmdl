
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ILOAD extends OpcodeFromBytes[ILOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ILOAD(byteBuffer.get())

  override def byteValue: Byte = 0x15.toByte
}

case class ILOAD(index: Byte) extends Opcode

  