
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ILOAD_0 extends OpcodeFromBytes[ILOAD_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ILOAD_0()

  override def byteValue: Byte = 0x1a.toByte
}

case class ILOAD_0() extends Opcode

  