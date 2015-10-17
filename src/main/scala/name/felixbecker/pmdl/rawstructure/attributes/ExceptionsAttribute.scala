package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

object ExceptionsAttribute extends AttributeInfoFromByteBuffer[ExceptionsAttribute] {

  /*
Exceptions_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 number_of_exceptions;
    u2 exception_index_table[number_of_exceptions];
}
 */

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): ExceptionsAttribute =  {
    val numberOfExceptions = byteBuffer.getShort()
    val exceptions = (1 to numberOfExceptions).map(_ => byteBuffer.getShort()).toList
    ExceptionsAttribute(numberOfExceptions, exceptions)
  }

  override def getAttributeName: String = "Exceptions"
}

case class ExceptionsAttribute(numberOfExceptions: Short, exceptionIndexTable: List[Short]) extends AttributeInfo