package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFEQ extends OpcodeFromBytes[IFEQ] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFEQ(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x99.toByte
}

case class IFEQ(branchbyte1: Byte, branchbyte2: Byte) extends Opcode
