
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ILOAD_1 extends OpcodeFromBytes[ILOAD_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ILOAD_1()

  override def byteValue: Byte = 0x1b.toByte
}

case class ILOAD_1() extends Opcode

  