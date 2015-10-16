package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object L2F extends OpcodeFromBytes[L2F] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = L2F()

  override def byteValue: Byte = 0x89.toByte
}

case class L2F() extends Opcode
