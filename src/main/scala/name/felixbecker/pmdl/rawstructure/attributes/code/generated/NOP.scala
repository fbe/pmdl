
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object NOP extends OpcodeFromBytes[NOP] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = NOP()

  override def byteValue: Byte = 0x0.toByte
}

case class NOP() extends Opcode

  