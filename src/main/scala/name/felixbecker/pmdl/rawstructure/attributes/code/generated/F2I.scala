
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object F2I extends OpcodeFromBytes[F2I] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = F2I()

  override def byteValue: Byte = 0x8b.toByte
}

case class F2I() extends Opcode

  