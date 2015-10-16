
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FREM extends OpcodeFromBytes[FREM] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FREM()

  override def byteValue: Byte = 0x72.toByte
}

case class FREM() extends Opcode

  