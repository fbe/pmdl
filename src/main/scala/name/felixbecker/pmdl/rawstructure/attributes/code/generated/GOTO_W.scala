package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object GOTO_W extends OpcodeFromBytes[GOTO_W] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = GOTO_W(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xc8.toByte
}

case class GOTO_W(branchbyte1: Byte, branchbyte2: Byte, branchbyte3: Byte, branchbyte4: Byte) extends Opcode
