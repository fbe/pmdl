package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LRETURN extends OpcodeFromBytes[LRETURN] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LRETURN()

  override def byteValue: Byte = 0xad.toByte
}

case class LRETURN() extends Opcode
