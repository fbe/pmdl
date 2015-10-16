
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFNE extends OpcodeFromBytes[IFNE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFNE(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x9a.toByte
}

case class IFNE(branchbyte1: Byte, branchbyte2: Byte) extends Opcode

  