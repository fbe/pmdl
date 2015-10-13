package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/*
StackMapTable_attribute {
    u2              attribute_name_index;
    u4              attribute_length;
    u2              number_of_entries;
    stack_map_frame entries[number_of_entries];
}
 */
object StackMapTableAttribute extends AttributeInfoFromByteBuffer[StackMapTableAttribute] {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): StackMapTableAttribute = {
    StackMapTableAttribute(byteBuffer, "PARSE ME TODO broken tack map table :(")
  }

  override def getAttributeName: String = "StackMapTable"

}
case class StackMapTableAttribute(byteBuffer: ByteBuffer, name: String) extends AttributeInfo
