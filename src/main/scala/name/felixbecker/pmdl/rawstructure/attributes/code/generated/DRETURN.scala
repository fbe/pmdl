package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DRETURN extends OpcodeFromBytes[DRETURN] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DRETURN()

  override def byteValue: Byte = 0xaf.toByte
}

case class DRETURN() extends Opcode
