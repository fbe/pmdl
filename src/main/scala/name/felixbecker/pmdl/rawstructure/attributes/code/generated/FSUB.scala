package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FSUB extends OpcodeFromBytes[FSUB] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FSUB()

  override def byteValue: Byte = 0x66.toByte
}

case class FSUB() extends Opcode
