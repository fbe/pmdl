package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object INVOKESPECIAL extends OpcodeFromBytes[INVOKESPECIAL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKESPECIAL(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb7.toByte
}

case class INVOKESPECIAL(indexbyte1: Byte, indexbyte2: Byte) extends Opcode
