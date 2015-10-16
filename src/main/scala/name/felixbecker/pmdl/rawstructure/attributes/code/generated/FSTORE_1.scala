package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FSTORE_1 extends OpcodeFromBytes[FSTORE_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FSTORE_1()

  override def byteValue: Byte = 0x44.toByte
}

case class FSTORE_1() extends Opcode
