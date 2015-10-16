package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISHL extends OpcodeFromBytes[ISHL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISHL()

  override def byteValue: Byte = 0x78.toByte
}

case class ISHL() extends Opcode
