
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object ICONST2 extends OpcodeFromBytes[ICONST2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST2()

  override def byteValue: Byte = 0x05.toByte
}

case class ICONST2() extends Opcode

