
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object INVOKEVIRTUAL extends OpcodeFromBytes[INVOKEVIRTUAL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKEVIRTUAL(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb6.toByte
}

case class INVOKEVIRTUAL(index1: Byte, index2: Byte) extends Opcode

