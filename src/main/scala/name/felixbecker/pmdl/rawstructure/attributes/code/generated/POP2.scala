
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object POP2 extends OpcodeFromBytes[POP2] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = POP2()

  override def byteValue: Byte = 0x58.toByte
}

case class POP2() extends Opcode

  