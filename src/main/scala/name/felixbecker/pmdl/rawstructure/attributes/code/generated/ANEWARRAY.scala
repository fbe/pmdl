
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ANEWARRAY extends OpcodeFromBytes[ANEWARRAY] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ANEWARRAY(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xbd.toByte
}

case class ANEWARRAY(indexbyte1: Byte, indexbyte2: Byte) extends Opcode

  