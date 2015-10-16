
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ALOAD_2 extends OpcodeFromBytes[ALOAD_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ALOAD_2()

  override def byteValue: Byte = 0x2c.toByte
}

case class ALOAD_2() extends Opcode

  