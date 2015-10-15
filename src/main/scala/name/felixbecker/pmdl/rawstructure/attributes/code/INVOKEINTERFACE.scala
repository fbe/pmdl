
package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object INVOKEINTERFACE extends OpcodeFromBytes[INVOKEINTERFACE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = INVOKEINTERFACE(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get())

  override def byteValue: Byte = 0xb9.toByte
}

case class INVOKEINTERFACE(index1: Byte, index2: Byte, count: Byte, zeroByte: Byte) extends Opcode

