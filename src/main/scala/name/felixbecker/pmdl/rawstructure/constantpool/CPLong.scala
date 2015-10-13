package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

/*
  CONSTANT_Long_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
  }
*/

case class CPLong(cpIndex: Short, value: Long) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

object CPLong extends CPElementFromByteBuffer[CPLong] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPLong = {

    val longValue = byteBuffer.getLong
    CPLong(constantPoolIndex, longValue)

  }

  override def getConstantPoolTag: Byte = 5

  // override for double and long, the use 2 slots in the constant pool
  override def requiredSlots: Short = 2
}