package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DSUB extends OpcodeFromBytes[DSUB] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DSUB()

  override def byteValue: Byte = 0x67.toByte
}

case class DSUB() extends Opcode
