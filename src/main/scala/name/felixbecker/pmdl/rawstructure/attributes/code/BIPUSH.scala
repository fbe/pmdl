
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object BIPUSH extends OpcodeFromBytes[BIPUSH] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = BIPUSH(byteBuffer.get())

  override def byteValue: Byte = 0x10.toByte
}

case class BIPUSH(byte: Byte) extends Opcode

