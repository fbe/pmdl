
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object RETURN extends OpcodeFromBytes[RETURN] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = RETURN()

  override def byteValue: Byte = 0xb1.toByte
}

case class RETURN() extends Opcode

  