package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ICONST_0 extends OpcodeFromBytes[ICONST_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST_0()

  override def byteValue: Byte = 0x3.toByte
}

case class ICONST_0() extends Opcode
