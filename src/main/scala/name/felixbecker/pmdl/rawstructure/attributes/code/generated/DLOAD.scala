package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DLOAD extends OpcodeFromBytes[DLOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DLOAD(byteBuffer.get())

  override def byteValue: Byte = 0x18.toByte
}

case class DLOAD(index: Byte) extends Opcode
