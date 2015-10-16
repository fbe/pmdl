
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IRETURN extends OpcodeFromBytes[IRETURN] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IRETURN()

  override def byteValue: Byte = 0xac.toByte
}

case class IRETURN() extends Opcode

  