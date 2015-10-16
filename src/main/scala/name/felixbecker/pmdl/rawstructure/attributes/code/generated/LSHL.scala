package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSHL extends OpcodeFromBytes[LSHL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSHL()

  override def byteValue: Byte = 0x79.toByte
}

case class LSHL() extends Opcode
