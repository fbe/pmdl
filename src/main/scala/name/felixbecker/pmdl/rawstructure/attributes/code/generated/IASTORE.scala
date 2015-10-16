package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IASTORE extends OpcodeFromBytes[IASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IASTORE()

  override def byteValue: Byte = 0x4f.toByte
}

case class IASTORE() extends Opcode
