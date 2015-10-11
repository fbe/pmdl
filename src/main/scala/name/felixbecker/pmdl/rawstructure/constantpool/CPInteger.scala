package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer


case class CPInteger(cpIndex: Short, value: Int) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

object CPInteger extends FromByteBuffer[CPInteger] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPInteger = {
    /*
         CONSTANT_Integer_info {
           u1 tag;
           u4 bytes;
         }
      */
    val intValue = byteBuffer.getInt()
    CPInteger(constantPoolIndex, intValue)
  }

  override def getConstantPoolTag: Byte = 3
}
