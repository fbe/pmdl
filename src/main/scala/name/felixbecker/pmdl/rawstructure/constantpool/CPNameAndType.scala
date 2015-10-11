package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer

/*
  CONSTANT_NameAndType_info {
    u1 tag;
    u2 name_index;
    u2 descriptor_index;
  }
*/

case class CPNameAndType(cpIndex: Short, nameIndex: Short, descriptorIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Name: $nameIndex, Descriptor: $descriptorIndex"
}

object CPNameAndType extends FromByteBuffer[CPNameAndType] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPNameAndType = {

    val nameIndex = byteBuffer.getShort
    val descriptorIndex = byteBuffer.getShort
    CPNameAndType(constantPoolIndex, nameIndex, descriptorIndex)

  }

  override def getConstantPoolTag: Byte = 12
}


