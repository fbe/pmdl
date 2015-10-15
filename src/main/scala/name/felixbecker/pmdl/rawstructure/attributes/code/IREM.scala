
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object IREM extends OpcodeFromBytes[IREM] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IREM()

  override def byteValue: Byte = 0x70.toByte
}

case class IREM() extends Opcode

