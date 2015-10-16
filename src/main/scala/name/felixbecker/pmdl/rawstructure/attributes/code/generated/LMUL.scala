package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LMUL extends OpcodeFromBytes[LMUL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LMUL()

  override def byteValue: Byte = 0x69.toByte
}

case class LMUL() extends Opcode
