
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object GETSTATIC extends OpcodeFromBytes[GETSTATIC] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = GETSTATIC(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb2.toByte
}

case class GETSTATIC(index1: Byte, index2: Byte) extends Opcode

