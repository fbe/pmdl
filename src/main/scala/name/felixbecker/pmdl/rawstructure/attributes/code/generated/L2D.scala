package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object L2D extends OpcodeFromBytes[L2D] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = L2D()

  override def byteValue: Byte = 0x8a.toByte
}

case class L2D() extends Opcode
