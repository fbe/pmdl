package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer


case class CPInterfaceMethodRef(cpIndex: Short, classIndex: Short, nameAndTypeIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Class: $classIndex, NameAndType: $nameAndTypeIndex"
}




object CPInterfaceMethodRef extends FromByteBuffer[CPInterfaceMethodRef] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPInterfaceMethodRef = {
    /*
           CONSTANT_InterfaceMethodref_info {
             u1 tag;
             u2 class_index;
             u2 name_and_type_index;
           }

       */

    val classIndex = byteBuffer.getShort
    val nameAndTypeIndex = byteBuffer.getShort
    CPInterfaceMethodRef(constantPoolIndex, classIndex, nameAndTypeIndex)
  }

  override def getConstantPoolTag: Byte = 11
}
