package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DCONST_1 extends OpcodeFromBytes[DCONST_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DCONST_1()

  override def byteValue: Byte = 0xf.toByte
}

case class DCONST_1() extends Opcode
