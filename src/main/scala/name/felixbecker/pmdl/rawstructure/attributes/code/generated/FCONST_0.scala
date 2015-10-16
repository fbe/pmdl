package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FCONST_0 extends OpcodeFromBytes[FCONST_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FCONST_0()

  override def byteValue: Byte = 0xb.toByte
}

case class FCONST_0() extends Opcode
