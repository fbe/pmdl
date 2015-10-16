package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IAND extends OpcodeFromBytes[IAND] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IAND()

  override def byteValue: Byte = 0x7e.toByte
}

case class IAND() extends Opcode
