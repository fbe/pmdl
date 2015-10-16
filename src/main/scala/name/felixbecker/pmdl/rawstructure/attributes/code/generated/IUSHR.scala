
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IUSHR extends OpcodeFromBytes[IUSHR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IUSHR()

  override def byteValue: Byte = 0x7c.toByte
}

case class IUSHR() extends Opcode

  