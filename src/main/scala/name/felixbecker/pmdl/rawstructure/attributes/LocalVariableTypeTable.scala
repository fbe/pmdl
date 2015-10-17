package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

object LocalVariableTypeTableAttribute extends AttributeInfoFromByteBuffer[LocalVariableTypeTableAttribute] {

  /*
  u2 attribute_name_index;
    u4 attribute_length;
    u2 local_variable_type_table_length;
    {   u2 start_pc;
        u2 length;
        u2 name_index;
        u2 signature_index;
        u2 index;
    } local_variable_type_table[local_variable_type_table_length];
 */

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): LocalVariableTypeTableAttribute =  {
    val numberOfLocalVariableTypeTableEntries = byteBuffer.getShort()

    val localVariableTypeTable = (1 to numberOfLocalVariableTypeTableEntries).map { _ =>
      LocalVariableTypeTableEntry(byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort())
    }.toList

    LocalVariableTypeTableAttribute(numberOfLocalVariableTypeTableEntries, localVariableTypeTable)
  }

  override def getAttributeName: String = "LocalVariableTypeTable"
}

case class LocalVariableTypeTableAttribute(localVariableTypeTableLength: Short, localVariableTypeTable: List[LocalVariableTypeTableEntry]) extends AttributeInfo
case class LocalVariableTypeTableEntry(startPc: Short, length: Short, nameIndex: Short, signatureIndex: Short, index: Short)