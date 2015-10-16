
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FCMPL extends OpcodeFromBytes[FCMPL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FCMPL()

  override def byteValue: Byte = 0x95.toByte
}

case class FCMPL() extends Opcode

  