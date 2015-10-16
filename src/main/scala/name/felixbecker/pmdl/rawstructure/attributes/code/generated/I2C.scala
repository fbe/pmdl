package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object I2C extends OpcodeFromBytes[I2C] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = I2C()

  override def byteValue: Byte = 0x92.toByte
}

case class I2C() extends Opcode
