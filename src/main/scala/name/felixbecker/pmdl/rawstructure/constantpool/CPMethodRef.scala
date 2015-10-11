package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

/*
  CONSTANT_Methodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
  }
*/

case class CPMethodRef(cpIndex: Short, classIndex: Short, nameAndType: Short) extends CPInfo {
  override def toStringInternal: String = s"Class: $classIndex, NameAndType: $nameAndType"
}

object CPMethodRef extends FromByteBuffer[CPMethodRef] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPMethodRef = {

    val classIndex = byteBuffer.getShort
    val nameAndType = byteBuffer.getShort

    CPMethodRef(constantPoolIndex, classIndex, nameAndType)
  }

  override def getConstantPoolTag: Byte = 10
}