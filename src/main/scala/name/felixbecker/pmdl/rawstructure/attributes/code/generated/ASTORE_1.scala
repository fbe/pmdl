
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ASTORE_1 extends OpcodeFromBytes[ASTORE_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ASTORE_1()

  override def byteValue: Byte = 0x4c.toByte
}

case class ASTORE_1() extends Opcode

  