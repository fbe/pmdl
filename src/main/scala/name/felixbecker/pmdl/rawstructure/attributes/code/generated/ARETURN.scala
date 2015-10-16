package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ARETURN extends OpcodeFromBytes[ARETURN] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ARETURN()

  override def byteValue: Byte = 0xb0.toByte
}

case class ARETURN() extends Opcode
