package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object SALOAD extends OpcodeFromBytes[SALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = SALOAD()

  override def byteValue: Byte = 0x35.toByte
}

case class SALOAD() extends Opcode
