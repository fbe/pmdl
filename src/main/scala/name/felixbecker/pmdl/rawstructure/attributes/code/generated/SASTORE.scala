
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object SASTORE extends OpcodeFromBytes[SASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = SASTORE()

  override def byteValue: Byte = 0x56.toByte
}

case class SASTORE() extends Opcode

  