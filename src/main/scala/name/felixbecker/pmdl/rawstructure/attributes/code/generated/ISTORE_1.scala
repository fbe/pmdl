
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISTORE_1 extends OpcodeFromBytes[ISTORE_1] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISTORE_1()

  override def byteValue: Byte = 0x3c.toByte
}

case class ISTORE_1() extends Opcode

  