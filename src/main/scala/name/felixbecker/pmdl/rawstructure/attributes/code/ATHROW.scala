
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object ATHROW extends OpcodeFromBytes[ATHROW] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ATHROW()

  override def byteValue: Byte = 0xbf.toByte
}

case class ATHROW() extends Opcode

