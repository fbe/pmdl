
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object ALOAD1 extends OpcodeFromBytes[ALOAD1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ALOAD1()

  override def byteValue: Byte = 0x2b.toByte
}

case class ALOAD1() extends Opcode

