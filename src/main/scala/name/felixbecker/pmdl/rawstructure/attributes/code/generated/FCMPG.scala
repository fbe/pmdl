
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FCMPG extends OpcodeFromBytes[FCMPG] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FCMPG()

  override def byteValue: Byte = 0x96.toByte
}

case class FCMPG() extends Opcode

  