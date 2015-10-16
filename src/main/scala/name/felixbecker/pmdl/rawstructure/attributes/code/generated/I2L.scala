package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object I2L extends OpcodeFromBytes[I2L] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = I2L()

  override def byteValue: Byte = 0x85.toByte
}

case class I2L() extends Opcode
