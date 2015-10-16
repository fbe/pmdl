
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object MULTIANEWARRAY extends OpcodeFromBytes[MULTIANEWARRAY] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = MULTIANEWARRAY(byteBuffer.get(), byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xc5.toByte
}

case class MULTIANEWARRAY(indexbyte1: Byte, indexbyte2: Byte, dimensions: Byte) extends Opcode

  