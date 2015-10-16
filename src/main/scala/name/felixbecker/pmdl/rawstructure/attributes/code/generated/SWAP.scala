
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object SWAP extends OpcodeFromBytes[SWAP] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = SWAP()

  override def byteValue: Byte = 0x5f.toByte
}

case class SWAP() extends Opcode

  