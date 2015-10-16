package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object AASTORE extends OpcodeFromBytes[AASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = AASTORE()

  override def byteValue: Byte = 0x53.toByte
}

case class AASTORE() extends Opcode
