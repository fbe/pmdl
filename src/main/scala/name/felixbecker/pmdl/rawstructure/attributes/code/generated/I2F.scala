
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object I2F extends OpcodeFromBytes[I2F] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = I2F()

  override def byteValue: Byte = 0x86.toByte
}

case class I2F() extends Opcode

  