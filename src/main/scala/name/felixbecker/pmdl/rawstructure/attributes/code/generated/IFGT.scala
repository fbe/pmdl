
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IFGT extends OpcodeFromBytes[IFGT] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IFGT(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x9d.toByte
}

case class IFGT(branchbyte1: Byte, branchbyte2: Byte) extends Opcode

  