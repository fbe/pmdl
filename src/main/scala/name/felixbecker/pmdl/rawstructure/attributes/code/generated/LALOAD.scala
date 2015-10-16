
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LALOAD extends OpcodeFromBytes[LALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LALOAD()

  override def byteValue: Byte = 0x2f.toByte
}

case class LALOAD() extends Opcode

  