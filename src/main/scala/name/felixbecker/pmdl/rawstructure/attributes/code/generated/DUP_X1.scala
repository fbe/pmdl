package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DUP_X1 extends OpcodeFromBytes[DUP_X1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DUP_X1()

  override def byteValue: Byte = 0x5a.toByte
}

case class DUP_X1() extends Opcode
