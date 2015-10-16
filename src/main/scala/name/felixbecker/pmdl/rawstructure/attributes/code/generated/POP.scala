package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object POP extends OpcodeFromBytes[POP] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = POP()

  override def byteValue: Byte = 0x57.toByte
}

case class POP() extends Opcode
