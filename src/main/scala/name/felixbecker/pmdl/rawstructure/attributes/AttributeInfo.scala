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



















