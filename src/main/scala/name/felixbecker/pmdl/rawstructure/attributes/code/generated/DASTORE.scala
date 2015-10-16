
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DASTORE extends OpcodeFromBytes[DASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DASTORE()

  override def byteValue: Byte = 0x52.toByte
}

case class DASTORE() extends Opcode

  