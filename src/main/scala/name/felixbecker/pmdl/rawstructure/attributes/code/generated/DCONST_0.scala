
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DCONST_0 extends OpcodeFromBytes[DCONST_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DCONST_0()

  override def byteValue: Byte = 0xe.toByte
}

case class DCONST_0() extends Opcode

  