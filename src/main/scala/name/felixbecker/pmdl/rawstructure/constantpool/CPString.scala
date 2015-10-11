package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer


object CPString extends FromByteBuffer[CPString] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPString = {
    val stringIndex = byteBuffer.getShort
    CPString(constantPoolIndex, stringIndex)
  }

  override def getConstantPoolTag: Byte = 8
}
case class CPString(cpIndex: Short, stringIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"String: $stringIndex"
}

