package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IDIV extends OpcodeFromBytes[IDIV] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IDIV()

  override def byteValue: Byte = 0x6c.toByte
}

case class IDIV() extends Opcode
