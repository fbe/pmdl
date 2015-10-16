
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DCMPG extends OpcodeFromBytes[DCMPG] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DCMPG()

  override def byteValue: Byte = 0x98.toByte
}

case class DCMPG() extends Opcode

  