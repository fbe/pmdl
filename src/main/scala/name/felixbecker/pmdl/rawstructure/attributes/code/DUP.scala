
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object DUP extends OpcodeFromBytes[DUP] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DUP()

  override def byteValue: Byte = 0x59.toByte
}

case class DUP() extends Opcode

