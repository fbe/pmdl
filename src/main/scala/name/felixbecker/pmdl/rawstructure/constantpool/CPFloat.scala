package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer

/**
 * Created by becker on 10/11/15.
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