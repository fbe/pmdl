
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ICONST_2 extends OpcodeFromBytes[ICONST_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST_2()

  override def byteValue: Byte = 0x5.toByte
}

case class ICONST_2() extends Opcode

  