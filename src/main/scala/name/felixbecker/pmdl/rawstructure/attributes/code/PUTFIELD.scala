package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/15/15.
 */
case class PUTFIELD(index1: Byte, index2: Byte) extends Opcode

object PUTFIELD extends OpcodeFromBytes[PUTFIELD] {
  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = {
    PUTFIELD(byteBuffer.get(), byteBuffer.get())
  }

  override def byteValue: Byte = 0xb5.toByte
}
