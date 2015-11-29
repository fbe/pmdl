package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/*
   u2 attribute_name_index;
    u4 attribute_length;
    u2 class_index;
    u2 method_index;
 */

object EnclosingMethodAttribute extends AttributeInfoFromByteBuffer[EnclosingMethodAttribute]{

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): EnclosingMethodAttribute = {
    EnclosingMethodAttribute(byteBuffer.getShort(), byteBuffer.getShort())
  }

  override def getAttributeName: String = "EnclosingMethod"

}

case class EnclosingMethodAttribute(classIndex: Short, methodIndex: Short) extends AttributeInfo