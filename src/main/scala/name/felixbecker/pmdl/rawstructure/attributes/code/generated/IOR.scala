
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object IOR extends OpcodeFromBytes[IOR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = IOR()

  override def byteValue: Byte = 0x80.toByte
}

case class IOR() extends Opcode

  