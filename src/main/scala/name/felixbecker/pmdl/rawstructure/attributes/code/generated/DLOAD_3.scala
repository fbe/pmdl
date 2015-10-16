
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DLOAD_3 extends OpcodeFromBytes[DLOAD_3] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DLOAD_3()

  override def byteValue: Byte = 0x29.toByte
}

case class DLOAD_3() extends Opcode

  