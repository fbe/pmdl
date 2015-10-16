package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DUP2 extends OpcodeFromBytes[DUP2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DUP2()

  override def byteValue: Byte = 0x5c.toByte
}

case class DUP2() extends Opcode
