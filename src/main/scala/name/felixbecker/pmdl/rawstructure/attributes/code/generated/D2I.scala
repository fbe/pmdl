package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object D2I extends OpcodeFromBytes[D2I] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = D2I()

  override def byteValue: Byte = 0x8e.toByte
}

case class D2I() extends Opcode
