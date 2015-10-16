package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DSTORE_2 extends OpcodeFromBytes[DSTORE_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DSTORE_2()

  override def byteValue: Byte = 0x49.toByte
}

case class DSTORE_2() extends Opcode
