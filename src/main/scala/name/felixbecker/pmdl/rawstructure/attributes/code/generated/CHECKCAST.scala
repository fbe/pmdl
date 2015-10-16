package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object CHECKCAST extends OpcodeFromBytes[CHECKCAST] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = CHECKCAST(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xc0.toByte
}

case class CHECKCAST(indexbyte1: Byte, indexbyte2: Byte) extends Opcode
