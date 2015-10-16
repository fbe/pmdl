package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IMUL extends OpcodeFromBytes[IMUL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IMUL()

  override def byteValue: Byte = 0x68.toByte
}

case class IMUL() extends Opcode
