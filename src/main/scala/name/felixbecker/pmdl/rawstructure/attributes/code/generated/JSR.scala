
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object JSR extends OpcodeFromBytes[JSR] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = JSR(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xa8.toByte
}

case class JSR(branchbyte1: Byte, branchbyte2: Byte) extends Opcode

  