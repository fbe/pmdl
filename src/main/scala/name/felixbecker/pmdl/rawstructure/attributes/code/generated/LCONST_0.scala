package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LCONST_0 extends OpcodeFromBytes[LCONST_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LCONST_0()

  override def byteValue: Byte = 0x9.toByte
}

case class LCONST_0() extends Opcode
