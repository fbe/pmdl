
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DLOAD_0 extends OpcodeFromBytes[DLOAD_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DLOAD_0()

  override def byteValue: Byte = 0x26.toByte
}

case class DLOAD_0() extends Opcode

  