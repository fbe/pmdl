
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ARRAYLENGTH extends OpcodeFromBytes[ARRAYLENGTH] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ARRAYLENGTH()

  override def byteValue: Byte = 0xbe.toByte
}

case class ARRAYLENGTH() extends Opcode

  