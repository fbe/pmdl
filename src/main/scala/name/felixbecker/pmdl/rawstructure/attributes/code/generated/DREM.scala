
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DREM extends OpcodeFromBytes[DREM] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DREM()

  override def byteValue: Byte = 0x73.toByte
}

case class DREM() extends Opcode

  