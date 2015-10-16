
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ICONST_1 extends OpcodeFromBytes[ICONST_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST_1()

  override def byteValue: Byte = 0x4.toByte
}

case class ICONST_1() extends Opcode

  