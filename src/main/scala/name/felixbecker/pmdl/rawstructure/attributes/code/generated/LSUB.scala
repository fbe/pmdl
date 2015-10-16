
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSUB extends OpcodeFromBytes[LSUB] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSUB()

  override def byteValue: Byte = 0x65.toByte
}

case class LSUB() extends Opcode

  