
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object INVOKEINTERFACE extends OpcodeFromBytes[INVOKEINTERFACE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKEINTERFACE(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb9.toByte
}

case class INVOKEINTERFACE(indexbyte1: Byte, indexbyte2: Byte, count: Byte, zeroByte1: Byte) extends Opcode

  