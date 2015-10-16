
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSTORE_3 extends OpcodeFromBytes[LSTORE_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSTORE_3()

  override def byteValue: Byte = 0x42.toByte
}

case class LSTORE_3() extends Opcode

  