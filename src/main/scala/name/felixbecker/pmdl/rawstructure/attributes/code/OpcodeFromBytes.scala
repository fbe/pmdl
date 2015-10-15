package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/15/15.
 */
trait OpcodeFromBytes[T <: Opcode] {
  def parseFromByte(byteBuffer: ByteBuffer): Opcode
  def byteValue: Byte

}
