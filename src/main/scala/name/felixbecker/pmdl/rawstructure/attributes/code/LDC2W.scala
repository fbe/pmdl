package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/13/15.
 */



case class LDC2W(index1: Byte, index2: Byte) extends Opcode
object LDC2W extends OpcodeFromBytes[LDC2W] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = {
    LDC2W(byteBuffer.get(), byteBuffer.get())
  }

  override def byteValue: Byte = 0x14

}