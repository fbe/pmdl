package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IALOAD extends OpcodeFromBytes[IALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IALOAD()

  override def byteValue: Byte = 0x2e.toByte
}

case class IALOAD() extends Opcode
