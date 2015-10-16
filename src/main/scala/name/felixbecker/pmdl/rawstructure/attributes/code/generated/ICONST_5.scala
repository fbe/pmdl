
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ICONST_5 extends OpcodeFromBytes[ICONST_5] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST_5()

  override def byteValue: Byte = 0x8.toByte
}

case class ICONST_5() extends Opcode

  