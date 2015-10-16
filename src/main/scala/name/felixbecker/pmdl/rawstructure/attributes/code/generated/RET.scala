package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object RET extends OpcodeFromBytes[RET] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = RET(byteBuffer.get())

  override def byteValue: Byte = 0xa9.toByte
}

case class RET(index: Byte) extends Opcode
