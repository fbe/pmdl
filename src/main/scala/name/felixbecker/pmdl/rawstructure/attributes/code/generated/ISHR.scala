package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISHR extends OpcodeFromBytes[ISHR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISHR()

  override def byteValue: Byte = 0x7a.toByte
}

case class ISHR() extends Opcode
