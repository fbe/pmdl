
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IF_ICMPLE extends OpcodeFromBytes[IF_ICMPLE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IF_ICMPLE(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa4.toByte
}

case class IF_ICMPLE(branchbyte1: Byte, branchbyte2: Byte) extends Opcode

  