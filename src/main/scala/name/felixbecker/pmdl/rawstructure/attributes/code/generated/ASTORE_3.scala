
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ASTORE_3 extends OpcodeFromBytes[ASTORE_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ASTORE_3()

  override def byteValue: Byte = 0x4e.toByte
}

case class ASTORE_3() extends Opcode

  