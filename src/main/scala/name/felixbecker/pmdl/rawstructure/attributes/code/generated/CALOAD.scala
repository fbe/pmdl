
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object CALOAD extends OpcodeFromBytes[CALOAD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = CALOAD()

  override def byteValue: Byte = 0x34.toByte
}

case class CALOAD() extends Opcode

  