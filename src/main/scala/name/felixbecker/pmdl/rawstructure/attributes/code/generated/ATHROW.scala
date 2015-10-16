
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ATHROW extends OpcodeFromBytes[ATHROW] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ATHROW()

  override def byteValue: Byte = 0xbf.toByte
}

case class ATHROW() extends Opcode

  