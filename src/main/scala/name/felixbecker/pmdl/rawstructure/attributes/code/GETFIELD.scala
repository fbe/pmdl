
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object GETFIELD extends OpcodeFromBytes[GETFIELD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = GETFIELD(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb4.toByte
}

case class GETFIELD(index1: Byte, index2: Byte) extends Opcode

