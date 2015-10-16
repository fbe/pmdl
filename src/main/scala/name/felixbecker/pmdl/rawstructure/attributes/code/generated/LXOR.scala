
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LXOR extends OpcodeFromBytes[LXOR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LXOR()

  override def byteValue: Byte = 0x83.toByte
}

case class LXOR() extends Opcode

  