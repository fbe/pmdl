package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSHR extends OpcodeFromBytes[LSHR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSHR()

  override def byteValue: Byte = 0x7b.toByte
}

case class LSHR() extends Opcode
