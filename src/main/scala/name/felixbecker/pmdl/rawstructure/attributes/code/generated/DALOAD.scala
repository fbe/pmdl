package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DALOAD extends OpcodeFromBytes[DALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DALOAD()

  override def byteValue: Byte = 0x31.toByte
}

case class DALOAD() extends Opcode
