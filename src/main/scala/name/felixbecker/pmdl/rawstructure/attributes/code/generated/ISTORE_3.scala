
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISTORE_3 extends OpcodeFromBytes[ISTORE_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISTORE_3()

  override def byteValue: Byte = 0x3e.toByte
}

case class ISTORE_3() extends Opcode

  