package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

/*
  CONSTANT_Double_info {
    u1 tag;
    u4 high_bytes;
    u4 low_bytes;
  }
*/

case class CPDouble(cpIndex: Short, value: Double) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

object CPDouble extends FromByteBuffer[CPDouble] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPDouble = {

    val doubleValue = byteBuffer.getDouble()
    CPDouble(constantPoolIndex, doubleValue)

  }

  override def getConstantPoolTag: Byte = 6

  // override for double and long, the use 2 slots in the constant pool
  override def requiredSlots: Short = 2 // Has one empty slot
}


