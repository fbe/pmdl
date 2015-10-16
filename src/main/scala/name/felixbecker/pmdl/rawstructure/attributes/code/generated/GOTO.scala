
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object GOTO extends OpcodeFromBytes[GOTO] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = GOTO(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa7.toByte
}

case class GOTO(branchbyte1: Byte, branchbyte2: Byte) extends Opcode

  