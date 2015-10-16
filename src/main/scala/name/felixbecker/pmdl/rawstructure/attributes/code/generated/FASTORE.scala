
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object FASTORE extends OpcodeFromBytes[FASTORE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = FASTORE()

  override def byteValue: Byte = 0x51.toByte
}

case class FASTORE() extends Opcode

  