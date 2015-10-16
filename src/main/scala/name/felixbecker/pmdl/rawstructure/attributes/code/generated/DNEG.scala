package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DNEG extends OpcodeFromBytes[DNEG] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DNEG()

  override def byteValue: Byte = 0x77.toByte
}

case class DNEG() extends Opcode
