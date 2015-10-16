package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FCONST_2 extends OpcodeFromBytes[FCONST_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FCONST_2()

  override def byteValue: Byte = 0xd.toByte
}

case class FCONST_2() extends Opcode
