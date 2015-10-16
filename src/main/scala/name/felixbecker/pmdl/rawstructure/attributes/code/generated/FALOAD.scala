
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FALOAD extends OpcodeFromBytes[FALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FALOAD()

  override def byteValue: Byte = 0x30.toByte
}

case class FALOAD() extends Opcode

  