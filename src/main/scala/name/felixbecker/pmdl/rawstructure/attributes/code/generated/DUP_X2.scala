
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DUP_X2 extends OpcodeFromBytes[DUP_X2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DUP_X2()

  override def byteValue: Byte = 0x5b.toByte
}

case class DUP_X2() extends Opcode

  