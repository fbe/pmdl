
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ALOAD extends OpcodeFromBytes[ALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ALOAD(byteBuffer.get())

  override def byteValue: Byte = 0x19.toByte
}

case class ALOAD(index: Byte) extends Opcode

  