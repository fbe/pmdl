
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ICONST_M1 extends OpcodeFromBytes[ICONST_M1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ICONST_M1()

  override def byteValue: Byte = 0x2.toByte
}

case class ICONST_M1() extends Opcode

  