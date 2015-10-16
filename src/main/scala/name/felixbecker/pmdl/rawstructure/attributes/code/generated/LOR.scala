
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LOR extends OpcodeFromBytes[LOR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LOR()

  override def byteValue: Byte = 0x81.toByte
}

case class LOR() extends Opcode

  