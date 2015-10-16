
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object F2L extends OpcodeFromBytes[F2L] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = F2L()

  override def byteValue: Byte = 0x8c.toByte
}

case class F2L() extends Opcode

  