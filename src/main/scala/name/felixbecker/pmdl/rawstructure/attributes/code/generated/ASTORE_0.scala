
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ASTORE_0 extends OpcodeFromBytes[ASTORE_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ASTORE_0()

  override def byteValue: Byte = 0x4b.toByte
}

case class ASTORE_0() extends Opcode

  