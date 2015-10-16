package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FSTORE_0 extends OpcodeFromBytes[FSTORE_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FSTORE_0()

  override def byteValue: Byte = 0x43.toByte
}

case class FSTORE_0() extends Opcode
