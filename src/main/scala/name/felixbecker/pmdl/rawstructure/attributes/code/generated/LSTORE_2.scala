package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LSTORE_2 extends OpcodeFromBytes[LSTORE_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LSTORE_2()

  override def byteValue: Byte = 0x41.toByte
}

case class LSTORE_2() extends Opcode
