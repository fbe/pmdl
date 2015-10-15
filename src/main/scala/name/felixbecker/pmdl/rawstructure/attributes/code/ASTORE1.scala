
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object ASTORE1 extends OpcodeFromBytes[ASTORE1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ASTORE1()

  override def byteValue: Byte = 0x4c.toByte
}

case class ASTORE1() extends Opcode

