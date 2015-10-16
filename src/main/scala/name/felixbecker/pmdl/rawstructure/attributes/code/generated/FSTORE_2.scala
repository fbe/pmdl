package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FSTORE_2 extends OpcodeFromBytes[FSTORE_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FSTORE_2()

  override def byteValue: Byte = 0x45.toByte
}

case class FSTORE_2() extends Opcode
