package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFNULL extends OpcodeFromBytes[IFNULL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFNULL(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xc6.toByte
}

case class IFNULL(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
