package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/15/15.
 */
case class AALOAD() extends Opcode
object AALOAD extends OpcodeFromBytes[AALOAD] {
  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = AALOAD()
  override def byteValue: Byte = 0x32
}
