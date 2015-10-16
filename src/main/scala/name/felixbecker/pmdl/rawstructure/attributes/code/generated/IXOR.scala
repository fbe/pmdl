package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IXOR extends OpcodeFromBytes[IXOR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IXOR()

  override def byteValue: Byte = 0x82.toByte
}

case class IXOR() extends Opcode
