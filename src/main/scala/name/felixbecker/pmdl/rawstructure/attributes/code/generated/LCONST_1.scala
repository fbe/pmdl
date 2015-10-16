
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LCONST_1 extends OpcodeFromBytes[LCONST_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LCONST_1()

  override def byteValue: Byte = 0xa.toByte
}

case class LCONST_1() extends Opcode

  