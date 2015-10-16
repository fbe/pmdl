package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object I2D extends OpcodeFromBytes[I2D] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = I2D()

  override def byteValue: Byte = 0x87.toByte
}

case class I2D() extends Opcode
