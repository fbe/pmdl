package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object BASTORE extends OpcodeFromBytes[BASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = BASTORE()

  override def byteValue: Byte = 0x54.toByte
}

case class BASTORE() extends Opcode
