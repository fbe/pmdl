package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

case class LocalVariableTableEntry(startPc: Short, nameIndex: Short, descriptorIndex: Short, index: Short)

case class LocalVariableTableAttribute(localVariableTableLength: Short, entries: List[LocalVariableTableEntry]) extends AttributeInfo

object LocalVariableTableAttribute extends AttributeInfoFromByteBuffer[LocalVariableTableAttribute] {

  /*
  LocalVariableTable_attribute {
 X  u2 attribute_name_index;
 X  u4 attribute_length;
    u2 local_variable_table_length;
    {   u2 start_pc;
        u2 length;
        u2 name_index;
        u2 descriptor_index;
        u2 index;
    } local_variable_table[local_variable_table_length];
   */


  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): LocalVariableTableAttribute = {
    val localVariableTableLength = byteBuffer.getShort()

    val tableEntries = (1 to localVariableTableLength).map { _ =>
      LocalVariableTableEntry(byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort())
    }.toList

    LocalVariableTableAttribute(localVariableTableLength, tableEntries)
  }

  override def getAttributeName: String = "LocalVariableTable"
}