
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ICONST_3 extends OpcodeFromBytes[ICONST_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST_3()

  override def byteValue: Byte = 0x6.toByte
}

case class ICONST_3() extends Opcode

  