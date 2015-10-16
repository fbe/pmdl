package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DCMPL extends OpcodeFromBytes[DCMPL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DCMPL()

  override def byteValue: Byte = 0x97.toByte
}

case class DCMPL() extends Opcode
