
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object LLOAD_1 extends OpcodeFromBytes[LLOAD_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = LLOAD_1()

  override def byteValue: Byte = 0x1f.toByte
}

case class LLOAD_1() extends Opcode

  