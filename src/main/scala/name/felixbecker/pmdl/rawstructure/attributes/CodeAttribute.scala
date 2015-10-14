package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object CodeAttribute extends AttributeInfoFromByteBuffer[CodeAttribute] {

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


  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): CodeAttribute = {

    val maxStack = byteBuffer.getShort()
    val maxLocals = byteBuffer.getShort()
    val codeLength = byteBuffer.getInt()

    val code = (1 to codeLength).map { _ => byteBuffer.get()}.toArray
    val exceptionTableLength = byteBuffer.getShort()

    val exceptionTableEntries = (1 to exceptionTableLength).map { _ =>
      ExceptionTableEntry(byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort())
    }.toList

    val attributesCount = byteBuffer.getShort()

    val attributes = AttributeInfo.fromByteBuffer(byteBuffer, attributesCount, constantPool)

    CodeAttribute(maxStack, maxLocals, codeLength, code, exceptionTableLength, exceptionTableEntries, attributesCount, attributes)

  }

  override def getAttributeName: String = "Code"

}



case class CodeAttribute(
  maxStack: Short,
  maxLocals: Short,
  codeLength: Int,
  code: Array[Byte],
  exceptionTableLength: Short,
  exceptionTableEntries: List[ExceptionTableEntry],
  attributeCount: Short,
  attributes: List[AttributeInfo]

) extends AttributeInfo {
  override def toString: String = {
    val head = "CodeAttribute\n"
    val bytes = ByteBuffer.wrap(code)

    var toString = ""

    while(bytes.hasRemaining){
      toString = toString + "%02x".format(bytes.get) + "\n"
    }


    head + toString

  }
}

case class ExceptionTableEntry(startPc: Short, endPc: Short, handlerPc: Short, catchType: Short)
