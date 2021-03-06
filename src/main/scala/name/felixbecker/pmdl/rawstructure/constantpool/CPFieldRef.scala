package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

/*
  CONSTANT_Fieldref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
  }
*/

case class CPFieldRef(cpIndex: Short, classIndex: Short, nameAndTypeIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Class: $classIndex, NameAndType: $nameAndTypeIndex"
}

object CPFieldRef extends CPElementFromByteBuffer[CPFieldRef] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPFieldRef = {

    val classIndex = byteBuffer.getShort
    val nameAndTypeIndex = byteBuffer.getShort
    CPFieldRef(constantPoolIndex, classIndex, nameAndTypeIndex)

  }

  override def getConstantPoolTag: Byte = 9
}
