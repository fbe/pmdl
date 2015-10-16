
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object I2B extends OpcodeFromBytes[I2B] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = I2B()

  override def byteValue: Byte = 0x91.toByte
}

case class I2B() extends Opcode

  