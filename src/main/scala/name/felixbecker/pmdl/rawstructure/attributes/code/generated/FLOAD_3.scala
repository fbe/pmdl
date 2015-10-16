
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FLOAD_3 extends OpcodeFromBytes[FLOAD_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FLOAD_3()

  override def byteValue: Byte = 0x25.toByte
}

case class FLOAD_3() extends Opcode

  