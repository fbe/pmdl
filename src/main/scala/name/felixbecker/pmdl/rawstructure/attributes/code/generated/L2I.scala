
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object L2I extends OpcodeFromBytes[L2I] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = L2I()

  override def byteValue: Byte = 0x88.toByte
}

case class L2I() extends Opcode

  