
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FRETURN extends OpcodeFromBytes[FRETURN] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FRETURN()

  override def byteValue: Byte = 0xae.toByte
}

case class FRETURN() extends Opcode

  