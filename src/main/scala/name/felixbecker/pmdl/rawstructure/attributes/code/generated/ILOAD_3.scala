package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ILOAD_3 extends OpcodeFromBytes[ILOAD_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ILOAD_3()

  override def byteValue: Byte = 0x1d.toByte
}

case class ILOAD_3() extends Opcode
