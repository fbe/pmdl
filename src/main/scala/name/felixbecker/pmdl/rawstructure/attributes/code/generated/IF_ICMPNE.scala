
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ICMPNE extends OpcodeFromBytes[IF_ICMPNE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ICMPNE(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa0.toByte
}

case class IF_ICMPNE(branchbyte1: Byte, branchbyte2: Byte) extends Opcode

  