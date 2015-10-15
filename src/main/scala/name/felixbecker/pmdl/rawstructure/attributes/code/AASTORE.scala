package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/15/15.
 */
case class AASTORE() extends Opcode

object AASTORE extends OpcodeFromBytes[AASTORE]{
  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = AASTORE()
  override def byteValue: Byte = 0x53
}


