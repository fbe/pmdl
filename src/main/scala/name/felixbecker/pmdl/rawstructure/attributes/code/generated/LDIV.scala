package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LDIV extends OpcodeFromBytes[LDIV] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LDIV()

  override def byteValue: Byte = 0x6d.toByte
}

case class LDIV() extends Opcode
