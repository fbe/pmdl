package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFLT extends OpcodeFromBytes[IFLT] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFLT(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x9b.toByte
}

case class IFLT(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
