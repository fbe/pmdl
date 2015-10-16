package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISTORE extends OpcodeFromBytes[ISTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISTORE(byteBuffer.get())

  override def byteValue: Byte = 0x36.toByte
}

case class ISTORE(index: Byte) extends Opcode
