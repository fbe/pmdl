package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FADD extends OpcodeFromBytes[FADD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FADD()

  override def byteValue: Byte = 0x62.toByte
}

case class FADD() extends Opcode
