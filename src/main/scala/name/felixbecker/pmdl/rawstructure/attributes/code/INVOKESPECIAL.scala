package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/15/15.
 */
object INVOKESPECIAL extends OpcodeFromBytes[INVOKESPECIAL] {
  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKESPECIAL(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb7.toByte
}

case class INVOKESPECIAL(index1: Byte, index2: Byte) extends Opcode
