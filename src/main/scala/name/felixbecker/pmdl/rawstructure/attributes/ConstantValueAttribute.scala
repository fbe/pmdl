package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

object ConstantValueAttribute extends AttributeInfoFromByteBuffer[ConstantValueAttribute] {

  /*
ConstantValue_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 constantvalue_index;
}
 */

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): ConstantValueAttribute =  {
    val constantValueIndex = byteBuffer.getShort()
    ConstantValueAttribute(constantValueIndex)
  }

  override def getAttributeName: String = "ConstantValue"
}

case class ConstantValueAttribute(constantValueIndex: Short) extends AttributeInfo