
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FDIV extends OpcodeFromBytes[FDIV] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FDIV()

  override def byteValue: Byte = 0x6e.toByte
}

case class FDIV() extends Opcode

  