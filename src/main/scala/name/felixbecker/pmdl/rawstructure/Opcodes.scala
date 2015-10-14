package name.felixbecker.pmdl.rawstructure

import java.nio.ByteBuffer

/**
 * Created by becker on 10/13/15.
 */

trait OpcodeFromBytes[T <: Opcode] {
  def parseFromByte(byteBuffer: ByteBuffer): Opcode
  def byteValue: Byte

}
trait Opcode

class Opcodes {


}

object AALOAD extends OpcodeFromBytes[AALOAD] {
  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = AALOAD()
  override def byteValue: Byte = 0x32
}

case class AALOAD() extends Opcode


object AASTORE extends OpcodeFromBytes[AASTORE]{
  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = AASTORE()
  override def byteValue: Byte = 0x53
}

case class AASTORE() extends Opcode



