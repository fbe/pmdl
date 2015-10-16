package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ASTORE extends OpcodeFromBytes[ASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ASTORE(byteBuffer.get())

  override def byteValue: Byte = 0x3a.toByte
}

case class ASTORE(index: Byte) extends Opcode
