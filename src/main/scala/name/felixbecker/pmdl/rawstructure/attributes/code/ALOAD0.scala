package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/15/15.
 */
object ALOAD0 extends OpcodeFromBytes[ALOAD0] {
  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ALOAD0()
  override def byteValue: Byte = 0x2a
}

case class ALOAD0() extends Opcode
