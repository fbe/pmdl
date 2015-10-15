
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object ARETURN extends OpcodeFromBytes[ARETURN] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ARETURN()

  override def byteValue: Byte = 0xb0.toByte
}

case class ARETURN() extends Opcode

