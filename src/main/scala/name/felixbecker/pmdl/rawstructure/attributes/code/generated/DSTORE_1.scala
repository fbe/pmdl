package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DSTORE_1 extends OpcodeFromBytes[DSTORE_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DSTORE_1()

  override def byteValue: Byte = 0x48.toByte
}

case class DSTORE_1() extends Opcode
