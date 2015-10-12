package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool


/*

Attributes are used in the ClassFile, field_info, method_info, and Code_attribute structures (§4.1, §4.5, §4.6, §4.7.3) of the class file format. All attributes have the following general format:

  attribute_info {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 info[attribute_length];
  }

  


 */

case class AttributeInfo(attributeNameIndex: Short, attributeLength: Int, attributeBytes: Array[Byte]) {
  override def toString: String =
    s"""
       | Attribute:
       |   Attribute name index: $attributeNameIndex
       |   Attribute length: $attributeLength
       |   ... some bytes (Parse me =))""".stripMargin
}

object AttributeInfo {


  val predefinedAttributes = List(
    "Attribute",
    "ConstantValue",
    "Code",
    "StackMapTable",
    "Exceptions",
    "InnerClasses",
    "EnclosingMethod",
    "Synthetic",
    "Signature",
    "SourceFile",
    "SourceDebugExtension",
    "LineNumberTable",
    "LocalVariableTable",
    "LocalVariableTypeTable",
    "Deprecated",
    "RuntimeVisibleAnnotations",
    "RuntimeInvisibleAnnotations",
    "RuntimeVisibleParameterAnnotations",
    "RuntimeInvisibleParameterAnnotations",
    "AnnotationDefault",
    "BootstrapMethods"
  )


  def fromByteBuffer(byteBuffer: ByteBuffer, attributesCount: Short, constantPool: ConstantPool): List[AttributeInfo] = {
    (1 to attributesCount).map { _ =>
      fromByteBuffer(byteBuffer, constantPool)
    }.toList
  }

  private def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): AttributeInfo = {
    val attributeNameIndex = byteBuffer.getShort()
    val attributeLength = byteBuffer.getInt()
    val attributeBytes = (1 to attributeLength).map { _ => byteBuffer.get() }.toArray

    val attributeName = constantPool.getString(attributeNameIndex)

    attributeName match {
      case "Code" =>
        CodeAttribute.parseFromBytes(ByteBuffer.wrap(attributeBytes), constantPool)
      case "LineNumberTable" =>
        LineNumberTableAttribute.parseFromBytes(ByteBuffer.wrap(attributeBytes), constantPool)
      case "ConstantValue" => ConstantValueAttribute.parseFromByteBuffer(ByteBuffer.wrap(attributeBytes), constantPool)
      case "LocalVariableTable" => LocalVariableTableAttribute.parseFromByteBuffer(ByteBuffer.wrap(attributeBytes), constantPool)
      case "SourceFile" => SourceFileAttribute.parseFromByteBuffer(ByteBuffer.wrap(attributeBytes), constantPool)
      case "RuntimeInvisibleAnnotations" => RuntimeInvisibleAnnotationsAttribute.parseFromByteBuffer(ByteBuffer.wrap(attributeBytes), constantPool)
      case x => println(s"other attribute, $attributeName")
    }

    //println(s"Attribute info: $attributeName")

    AttributeInfo(attributeNameIndex, attributeLength, attributeBytes)
  }

}

object RuntimeInvisibleAnnotationsAttribute {
  /*
  RuntimeInvisibleAnnotations_attribute {
X   u2         attribute_name_index;
X   u4         attribute_length;
    u2         num_annotations;
    annotation annotations[num_annotations];
  }
 */
  def parseFromByteBuffer(bytes: ByteBuffer, constantPool: ConstantPool): Unit = {
    val numAnnotations = bytes.getShort()

    /*
    annotation {
    u2 type_index;
    u2 num_element_value_pairs;
    {   u2            element_name_index;
        element_value value;
    } element_value_pairs[num_element_value_pairs];
}

     */

    println(s"RuntimeInvisibleAnnotationsAttribute - numAnnotations: $numAnnotations - bytes left: ${bytes.remaining()} TODO FIXME ADD ANNOTATION")
  }
}

object SourceFileAttribute {

  /*

  SourceFile_attribute {
X   u2 attribute_name_index;
X   u4 attribute_length;
    u2 sourcefile_index;
  }

  */
  def parseFromByteBuffer(bytes: ByteBuffer, constantPool: ConstantPool): Unit = {
    val sourceFileIndex = bytes.getShort()
    println(s"SourceFile index: $sourceFileIndex")
  }
}


case class LocalVariableTableEntry(startPc: Short, nameIndex: Short, descriptorIndex: Short, index: Short)
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

object ConstantValueAttribute {
/*
ConstantValue_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 constantvalue_index;
}
 */
  def parseFromByteBuffer(bytes: ByteBuffer, constantPool: ConstantPool): Unit = {
    val constantValueIndex = bytes.getShort()
    println(s"ConstantValueAttribute - constantValueIndex: $constantValueIndex")
  }
}

case class ExceptionTableEntry(startPc: Short, endPc: Short, handlerPc: Short, catchType: Short)


case class LineNumberTableEntry(startPc: Short, lineNumber: Short)
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