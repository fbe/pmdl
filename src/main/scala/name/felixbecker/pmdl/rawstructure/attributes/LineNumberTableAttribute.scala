package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object LineNumberTableAttribute {
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

  def parseFromBytes(bytes: ByteBuffer, constantPool: ConstantPool): Unit = {

    val lineNumberTableLength = bytes.getShort()

    val lineNumberTableEntries = (1 to lineNumberTableLength).map { _ =>
      LineNumberTableEntry(bytes.getShort(), bytes.getShort())
    }.toList

    println(s"LineNumberTable: length: $lineNumberTableLength, entries: ${lineNumberTableEntries.mkString(",")}")
  }

}

case class LineNumberTableEntry(startPc: Short, lineNumber: Short)
