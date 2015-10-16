package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object JSR_W extends OpcodeFromBytes[JSR_W] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = JSR_W(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xc9.toByte
}

case class JSR_W(branchbyte1: Byte, branchbyte2: Byte, branchbyte3: Byte, branchbyte4: Byte) extends Opcode
