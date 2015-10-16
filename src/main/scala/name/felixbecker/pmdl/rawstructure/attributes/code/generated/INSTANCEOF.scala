package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object INSTANCEOF extends OpcodeFromBytes[INSTANCEOF] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INSTANCEOF(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xc1.toByte
}

case class INSTANCEOF(indexbyte1: Byte, indexbyte2: Byte) extends Opcode
