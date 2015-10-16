package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object MONITORENTER extends OpcodeFromBytes[MONITORENTER] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = MONITORENTER()

  override def byteValue: Byte = 0xc2.toByte
}

case class MONITORENTER() extends Opcode
