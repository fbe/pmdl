package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LNEG extends OpcodeFromBytes[LNEG] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LNEG()

  override def byteValue: Byte = 0x75.toByte
}

case class LNEG() extends Opcode
