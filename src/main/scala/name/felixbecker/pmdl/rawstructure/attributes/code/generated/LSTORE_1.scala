package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSTORE_1 extends OpcodeFromBytes[LSTORE_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSTORE_1()

  override def byteValue: Byte = 0x40.toByte
}

case class LSTORE_1() extends Opcode
