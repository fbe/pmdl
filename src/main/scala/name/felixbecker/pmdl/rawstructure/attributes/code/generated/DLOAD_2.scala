
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object DLOAD_2 extends OpcodeFromBytes[DLOAD_2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = DLOAD_2()

  override def byteValue: Byte = 0x28.toByte
}

case class DLOAD_2() extends Opcode

  