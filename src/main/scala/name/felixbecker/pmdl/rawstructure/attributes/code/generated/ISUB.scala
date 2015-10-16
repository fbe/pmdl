package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISUB extends OpcodeFromBytes[ISUB] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISUB()

  override def byteValue: Byte = 0x64.toByte
}

case class ISUB() extends Opcode
