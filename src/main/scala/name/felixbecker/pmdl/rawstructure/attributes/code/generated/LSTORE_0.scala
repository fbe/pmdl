
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSTORE_0 extends OpcodeFromBytes[LSTORE_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSTORE_0()

  override def byteValue: Byte = 0x3f.toByte
}

case class LSTORE_0() extends Opcode

  