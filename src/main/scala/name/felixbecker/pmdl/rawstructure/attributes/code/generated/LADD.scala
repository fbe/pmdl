
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LADD extends OpcodeFromBytes[LADD] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LADD()

  override def byteValue: Byte = 0x61.toByte
}

case class LADD() extends Opcode

  