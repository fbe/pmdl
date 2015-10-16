package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object I2S extends OpcodeFromBytes[I2S] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = I2S()

  override def byteValue: Byte = 0x93.toByte
}

case class I2S() extends Opcode
