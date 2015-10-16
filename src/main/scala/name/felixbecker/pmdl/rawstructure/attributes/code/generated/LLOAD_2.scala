package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LLOAD_2 extends OpcodeFromBytes[LLOAD_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LLOAD_2()

  override def byteValue: Byte = 0x20.toByte
}

case class LLOAD_2() extends Opcode
