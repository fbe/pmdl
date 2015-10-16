
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ISTORE_2 extends OpcodeFromBytes[ISTORE_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ISTORE_2()

  override def byteValue: Byte = 0x3d.toByte
}

case class ISTORE_2() extends Opcode

  