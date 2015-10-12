package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object LocalVariableTableAttribute {
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

  def parseFromByteBuffer(bytes: ByteBuffer, constantPool: ConstantPool): Unit ={
    val localVariableTableLength = bytes.getShort()

    val tableEntries = (1 to localVariableTableLength).map { _ =>
      LocalVariableTableEntry(bytes.getShort(), bytes.getShort(), bytes.getShort(), bytes.getShort())
    }.toList

    println(s"LocalVariableTable - entries: $localVariableTableLength - ${tableEntries.mkString(",")}")
  }
}

case class LocalVariableTableEntry(startPc: Short, nameIndex: Short, descriptorIndex: Short, index: Short)

