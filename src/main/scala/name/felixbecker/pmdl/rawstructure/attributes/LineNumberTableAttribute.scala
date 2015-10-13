package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

object LineNumberTableAttribute extends AttributeInfoFromByteBuffer[LineNumberTableAttribute] {
  /*
  LineNumberTable_attribute {
X   u2 attribute_name_index;
X   u4 attribute_length;
    u2 line_number_table_length;
    {   u2 start_pc;
      u2 line_number;
    } line_number_table[line_number_table_length];
  }
  */

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): LineNumberTableAttribute = {

    val lineNumberTableLength = byteBuffer.getShort()

    val lineNumberTableEntries = (1 to lineNumberTableLength).map { _ =>
      LineNumberTableEntry(byteBuffer.getShort(), byteBuffer.getShort())
    }.toList

    LineNumberTableAttribute(lineNumberTableLength, lineNumberTableEntries)

  }

  override def getAttributeName: String = "LineNumberTable"
}

case class LineNumberTableAttribute(tableLength: Short, entries: List[LineNumberTableEntry]) extends AttributeInfo
case class LineNumberTableEntry(startPc: Short, lineNumber: Short)
