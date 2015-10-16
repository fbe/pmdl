
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object INEG extends OpcodeFromBytes[INEG] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INEG()

  override def byteValue: Byte = 0x74.toByte
}

case class INEG() extends Opcode

  