package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LREM extends OpcodeFromBytes[LREM] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LREM()

  override def byteValue: Byte = 0x71.toByte
}

case class LREM() extends Opcode
