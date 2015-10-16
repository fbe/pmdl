package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DADD extends OpcodeFromBytes[DADD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DADD()

  override def byteValue: Byte = 0x63.toByte
}

case class DADD() extends Opcode
