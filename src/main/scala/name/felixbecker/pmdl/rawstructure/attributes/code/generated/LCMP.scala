package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LCMP extends OpcodeFromBytes[LCMP] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LCMP()

  override def byteValue: Byte = 0x94.toByte
}

case class LCMP() extends Opcode
