
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FMUL extends OpcodeFromBytes[FMUL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FMUL()

  override def byteValue: Byte = 0x6a.toByte
}

case class FMUL() extends Opcode

  