package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LLOAD_3 extends OpcodeFromBytes[LLOAD_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LLOAD_3()

  override def byteValue: Byte = 0x21.toByte
}

case class LLOAD_3() extends Opcode
