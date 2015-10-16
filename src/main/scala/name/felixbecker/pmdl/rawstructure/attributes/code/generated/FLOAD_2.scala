
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FLOAD_2 extends OpcodeFromBytes[FLOAD_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FLOAD_2()

  override def byteValue: Byte = 0x24.toByte
}

case class FLOAD_2() extends Opcode

  