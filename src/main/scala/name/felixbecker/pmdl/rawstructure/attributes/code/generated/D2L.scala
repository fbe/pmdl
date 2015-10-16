package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object D2L extends OpcodeFromBytes[D2L] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = D2L()

  override def byteValue: Byte = 0x8f.toByte
}

case class D2L() extends Opcode
