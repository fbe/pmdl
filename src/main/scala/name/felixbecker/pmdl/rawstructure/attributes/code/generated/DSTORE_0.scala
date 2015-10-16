package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DSTORE_0 extends OpcodeFromBytes[DSTORE_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DSTORE_0()

  override def byteValue: Byte = 0x47.toByte
}

case class DSTORE_0() extends Opcode
