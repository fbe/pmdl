
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object NEWARRAY extends OpcodeFromBytes[NEWARRAY] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = NEWARRAY(byteBuffer.get())

  override def byteValue: Byte = 0xbc.toByte
}

case class NEWARRAY(atype: Byte) extends Opcode

  