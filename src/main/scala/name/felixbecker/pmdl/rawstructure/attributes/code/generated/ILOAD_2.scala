package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ILOAD_2 extends OpcodeFromBytes[ILOAD_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ILOAD_2()

  override def byteValue: Byte = 0x1c.toByte
}

case class ILOAD_2() extends Opcode
