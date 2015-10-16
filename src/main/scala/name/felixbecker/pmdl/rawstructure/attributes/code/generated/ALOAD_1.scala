
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ALOAD_1 extends OpcodeFromBytes[ALOAD_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ALOAD_1()

  override def byteValue: Byte = 0x2b.toByte
}

case class ALOAD_1() extends Opcode

  