package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FLOAD_0 extends OpcodeFromBytes[FLOAD_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FLOAD_0()

  override def byteValue: Byte = 0x22.toByte
}

case class FLOAD_0() extends Opcode
