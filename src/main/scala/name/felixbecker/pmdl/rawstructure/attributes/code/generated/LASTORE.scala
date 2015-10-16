
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LASTORE extends OpcodeFromBytes[LASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LASTORE()

  override def byteValue: Byte = 0x50.toByte
}

case class LASTORE() extends Opcode

  