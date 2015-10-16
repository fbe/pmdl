package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object BALOAD extends OpcodeFromBytes[BALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = BALOAD()

  override def byteValue: Byte = 0x33.toByte
}

case class BALOAD() extends Opcode
