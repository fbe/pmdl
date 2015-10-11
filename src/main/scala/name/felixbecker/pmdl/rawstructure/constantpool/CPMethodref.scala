package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer


case class CPMethodref(cpIndex: Short, classIndex: Short, nameAndType: Short) extends CPInfo {
  override def toStringInternal: String = s"Class: $classIndex, NameAndType: $nameAndType"
}


object CPMethodref extends FromByteBuffer[CPMethodref] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPMethodref = {

    /*
       CONSTANT_Methodref_info {
         u1 tag;
         u2 class_index;
         u2 name_and_type_index;
       }
    */

    val classIndex = byteBuffer.getShort
    val nameAndType = byteBuffer.getShort

    CPMethodref(constantPoolIndex, classIndex, nameAndType)
  }

  override def getConstantPoolTag: Byte = 10
}