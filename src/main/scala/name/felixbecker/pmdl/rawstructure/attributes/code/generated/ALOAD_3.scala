
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ALOAD_3 extends OpcodeFromBytes[ALOAD_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ALOAD_3()

  override def byteValue: Byte = 0x2d.toByte
}

case class ALOAD_3() extends Opcode

  