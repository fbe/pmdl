
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FSTORE extends OpcodeFromBytes[FSTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FSTORE(byteBuffer.get())

  override def byteValue: Byte = 0x38.toByte
}

case class FSTORE(index: Byte) extends Opcode

  