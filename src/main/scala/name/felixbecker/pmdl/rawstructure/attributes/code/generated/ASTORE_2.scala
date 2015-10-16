package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ASTORE_2 extends OpcodeFromBytes[ASTORE_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ASTORE_2()

  override def byteValue: Byte = 0x4d.toByte
}

case class ASTORE_2() extends Opcode
