
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LAND extends OpcodeFromBytes[LAND] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LAND()

  override def byteValue: Byte = 0x7f.toByte
}

case class LAND() extends Opcode

  