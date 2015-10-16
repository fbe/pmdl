package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object MONITOREXIT extends OpcodeFromBytes[MONITOREXIT] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = MONITOREXIT()

  override def byteValue: Byte = 0xc3.toByte
}

case class MONITOREXIT() extends Opcode
