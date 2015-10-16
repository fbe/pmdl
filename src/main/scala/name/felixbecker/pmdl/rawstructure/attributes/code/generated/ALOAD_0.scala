
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ALOAD_0 extends OpcodeFromBytes[ALOAD_0] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ALOAD_0()

  override def byteValue: Byte = 0x2a.toByte
}

case class ALOAD_0() extends Opcode

  