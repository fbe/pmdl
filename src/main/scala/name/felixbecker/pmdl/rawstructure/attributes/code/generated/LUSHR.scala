
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LUSHR extends OpcodeFromBytes[LUSHR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LUSHR()

  override def byteValue: Byte = 0x7d.toByte
}

case class LUSHR() extends Opcode

  