
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object F2D extends OpcodeFromBytes[F2D] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = F2D()

  override def byteValue: Byte = 0x8d.toByte
}

case class F2D() extends Opcode

  