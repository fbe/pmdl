package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

/*
  CONSTANT_Float_info {
    u1 tag;
    u4 bytes;
  }
*/

case class CPFloat(cpIndex: Short, value: Float) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

object CPFloat extends FromByteBuffer[CPFloat] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPFloat = {

    val floatValue = byteBuffer.getFloat
    CPFloat(constantPoolIndex, floatValue)

  }

  override def getConstantPoolTag: Byte = 4
}