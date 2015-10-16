package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DUP2_X2 extends OpcodeFromBytes[DUP2_X2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DUP2_X2()

  override def byteValue: Byte = 0x5e.toByte
}

case class DUP2_X2() extends Opcode
