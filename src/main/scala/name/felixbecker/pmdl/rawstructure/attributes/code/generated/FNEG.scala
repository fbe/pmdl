package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FNEG extends OpcodeFromBytes[FNEG] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FNEG()

  override def byteValue: Byte = 0x76.toByte
}

case class FNEG() extends Opcode
