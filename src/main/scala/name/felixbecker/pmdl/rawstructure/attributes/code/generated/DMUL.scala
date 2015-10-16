package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DMUL extends OpcodeFromBytes[DMUL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DMUL()

  override def byteValue: Byte = 0x6b.toByte
}

case class DMUL() extends Opcode
