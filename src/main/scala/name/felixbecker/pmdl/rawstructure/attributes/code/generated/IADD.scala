package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IADD extends OpcodeFromBytes[IADD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IADD()

  override def byteValue: Byte = 0x60.toByte
}

case class IADD() extends Opcode
