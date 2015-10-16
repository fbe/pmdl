package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DLOAD_1 extends OpcodeFromBytes[DLOAD_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DLOAD_1()

  override def byteValue: Byte = 0x27.toByte
}

case class DLOAD_1() extends Opcode
