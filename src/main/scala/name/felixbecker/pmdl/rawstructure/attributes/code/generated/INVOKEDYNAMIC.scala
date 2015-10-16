
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object INVOKEDYNAMIC extends OpcodeFromBytes[INVOKEDYNAMIC] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKEDYNAMIC(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xba.toByte
}

case class INVOKEDYNAMIC(indexbyte1: Byte, indexbyte2: Byte, zeroByte1: Byte, zeroByte2: Byte) extends Opcode

  