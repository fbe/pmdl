
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object AALOAD extends OpcodeFromBytes[AALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = AALOAD()

  override def byteValue: Byte = 0x32.toByte
}

case class AALOAD() extends Opcode

  