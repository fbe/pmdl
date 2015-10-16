package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DSTORE_3 extends OpcodeFromBytes[DSTORE_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DSTORE_3()

  override def byteValue: Byte = 0x4a.toByte
}

case class DSTORE_3() extends Opcode
