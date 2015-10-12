package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object CodeAttribute {

  /*

  Code_attribute {
X    u2 attribute_name_index;
X    u4 attribute_length;
    u2 max_stack;
    u2 max_locals;
    u4 code_length;
    u1 code[code_length];
    u2 exception_table_length;
    {   u2 start_pc;
        u2 end_pc;
        u2 handler_pc;
        u2 catch_type;
    } exception_table[exception_table_length];
    u2 attributes_count;
    attribute_info attributes[attributes_count];
}

   */


  def parseFromBytes(bytes: ByteBuffer, constantPool: ConstantPool): Unit ={
    val maxStack = bytes.getShort()
    val maxLocals = bytes.getShort()
    val codeLength = bytes.getInt()

    val code = (1 to codeLength).map { _ => bytes.get()}.toArray
    val exceptionTableLength = bytes.getShort()

    val exceptionTableEntries = (1 to exceptionTableLength).map { _ =>
      ExceptionTableEntry(bytes.getShort(), bytes.getShort(), bytes.getShort(), bytes.getShort())
    }.toList

    val attributesCount = bytes.getShort()

    val attributes = AttributeInfo.fromByteBuffer(bytes, attributesCount, constantPool)

    println(s"MaxStack: $maxStack, " +
      s"MaxLocals: $maxLocals, " +
      s"codeLength: $codeLength, " +
      s"Code: ${code.length}, " +
      s"ExceptionTableLength: $exceptionTableLength " +
      s"${exceptionTableEntries.mkString(",")} " +
      s"AttributesCount: ${attributesCount} " +
      s"Remaining buffer size: ${bytes.remaining()}")
  }
}
case class ExceptionTableEntry(startPc: Short, endPc: Short, handlerPc: Short, catchType: Short)
