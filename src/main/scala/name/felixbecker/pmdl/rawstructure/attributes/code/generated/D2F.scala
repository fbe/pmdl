
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object D2F extends OpcodeFromBytes[D2F] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = D2F()

  override def byteValue: Byte = 0x90.toByte
}

case class D2F() extends Opcode

  