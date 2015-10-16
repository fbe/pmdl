package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DDIV extends OpcodeFromBytes[DDIV] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DDIV()

  override def byteValue: Byte = 0x6f.toByte
}

case class DDIV() extends Opcode
