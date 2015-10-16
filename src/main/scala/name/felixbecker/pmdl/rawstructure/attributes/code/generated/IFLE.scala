
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFLE extends OpcodeFromBytes[IFLE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFLE(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x9e.toByte
}

case class IFLE(branchbyte1: Byte, branchbyte2: Byte) extends Opcode

  