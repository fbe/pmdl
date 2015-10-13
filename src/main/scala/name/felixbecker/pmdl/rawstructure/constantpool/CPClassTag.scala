package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

/*
  CONSTANT_Class_info {
    u1 tag;
    u2 name_index;
  }
*/

case class CPClassTag(cpIndex: Short, nameIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Name: $nameIndex"
}

object CPClassTag extends CPElementFromByteBuffer[CPClassTag] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPClassTag = {

    val nameIndex = byteBuffer.getShort
    CPClassTag(constantPoolIndex, nameIndex)

  }

  override def getConstantPoolTag: Byte = 7
}