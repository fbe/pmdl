
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ICONST_4 extends OpcodeFromBytes[ICONST_4] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST_4()

  override def byteValue: Byte = 0x7.toByte
}

case class ICONST_4() extends Opcode

  