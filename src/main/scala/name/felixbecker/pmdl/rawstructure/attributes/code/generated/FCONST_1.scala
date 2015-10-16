package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FCONST_1 extends OpcodeFromBytes[FCONST_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FCONST_1()

  override def byteValue: Byte = 0xc.toByte
}

case class FCONST_1() extends Opcode
