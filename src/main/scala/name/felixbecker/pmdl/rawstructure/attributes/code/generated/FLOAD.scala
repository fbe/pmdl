package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FLOAD extends OpcodeFromBytes[FLOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FLOAD(byteBuffer.get())

  override def byteValue: Byte = 0x17.toByte
}

case class FLOAD(index: Byte) extends Opcode
