package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FLOAD_1 extends OpcodeFromBytes[FLOAD_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FLOAD_1()

  override def byteValue: Byte = 0x23.toByte
}

case class FLOAD_1() extends Opcode
