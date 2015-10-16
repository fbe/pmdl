package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LLOAD_0 extends OpcodeFromBytes[LLOAD_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LLOAD_0()

  override def byteValue: Byte = 0x1e.toByte
}

case class LLOAD_0() extends Opcode
