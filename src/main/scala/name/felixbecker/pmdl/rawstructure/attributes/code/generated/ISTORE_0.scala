package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISTORE_0 extends OpcodeFromBytes[ISTORE_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISTORE_0()

  override def byteValue: Byte = 0x3b.toByte
}

case class ISTORE_0() extends Opcode
