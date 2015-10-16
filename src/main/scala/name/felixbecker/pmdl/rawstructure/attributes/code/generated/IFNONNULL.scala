package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFNONNULL extends OpcodeFromBytes[IFNONNULL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFNONNULL(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xc7.toByte
}

case class IFNONNULL(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
