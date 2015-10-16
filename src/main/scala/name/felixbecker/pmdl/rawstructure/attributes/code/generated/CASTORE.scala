package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object CASTORE extends OpcodeFromBytes[CASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = CASTORE()

  override def byteValue: Byte = 0x55.toByte
}

case class CASTORE() extends Opcode
