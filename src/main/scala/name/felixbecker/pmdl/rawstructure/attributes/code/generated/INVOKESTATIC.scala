
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object INVOKESTATIC extends OpcodeFromBytes[INVOKESTATIC] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKESTATIC(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb8.toByte
}

case class INVOKESTATIC(indexbyte1: Byte, indexbyte2: Byte) extends Opcode

  