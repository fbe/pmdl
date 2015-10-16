package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object INVOKEVIRTUAL extends OpcodeFromBytes[INVOKEVIRTUAL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKEVIRTUAL(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb6.toByte
}

case class INVOKEVIRTUAL(indexbyte1: Byte, indexbyte2: Byte) extends Opcode
