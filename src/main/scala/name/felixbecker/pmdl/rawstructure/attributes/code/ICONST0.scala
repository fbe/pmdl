
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object ICONST0 extends OpcodeFromBytes[ICONST0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST0()

  override def byteValue: Byte = 0x03.toByte
}

case class ICONST0() extends Opcode

