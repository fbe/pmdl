package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FSTORE_3 extends OpcodeFromBytes[FSTORE_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FSTORE_3()

  override def byteValue: Byte = 0x46.toByte
}

case class FSTORE_3() extends Opcode
