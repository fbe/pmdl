package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DSTORE extends OpcodeFromBytes[DSTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DSTORE(byteBuffer.get())

  override def byteValue: Byte = 0x39.toByte
}

case class DSTORE(index: Byte) extends Opcode
