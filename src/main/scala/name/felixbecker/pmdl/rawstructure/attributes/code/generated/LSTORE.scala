
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSTORE extends OpcodeFromBytes[LSTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSTORE(byteBuffer.get())

  override def byteValue: Byte = 0x37.toByte
}

case class LSTORE(index: Byte) extends Opcode

  