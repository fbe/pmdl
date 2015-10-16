
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object SIPUSH extends OpcodeFromBytes[SIPUSH] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = SIPUSH(byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0x11.toByte
}

case class SIPUSH(byte1: Byte, byte2: Byte) extends Opcode

  