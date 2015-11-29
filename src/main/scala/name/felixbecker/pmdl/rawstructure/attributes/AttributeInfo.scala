package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.attributes.code.CodeAttribute
import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool


/*

Attributes are used in the ClassFile, field_info, method_info, and Code_attribute structures (§4.1, §4.5, §4.6, §4.7.3) of the class file format. All attributes have the following general format:

  attribute_info {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 info[attribute_length];
  }

  


 */




trait AttributeInfo

object AttributeInfo {


  val attributeInfoCompanions = List[AttributeInfoFromByteBuffer[_ <: AttributeInfo]] (
    CodeAttribute,
    ConstantValueAttribute,
    LineNumberTableAttribute,
    LocalVariableTableAttribute,
    RuntimeInvisibleAnnotationsAttribute,
    SourceFileAttribute,
    StackMapTableAttribute,
    SignatureAttribute,
    ExceptionsAttribute,
    LocalVariableTypeTableAttribute,
    InnerClassesAttribute,
    EnclosingMethodAttribute,
    RuntimeInvisibleParameterAnnotationsAttribute,
    RuntimeVisibleAnnotationsParameterAttribute,
    AnnotationDefaultAttribute,
    DeprecatedAttribute,
    SyntheticAttribute
  ).map(a => a.getAttributeName -> a).toMap[String, AttributeInfoFromByteBuffer[_ <: AttributeInfo]]


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

    val attributeCompanion = attributeInfoCompanions.getOrElse(attributeName, throw new RuntimeException(s"Cannot parse Attribute with name $attributeName - not known!"))

    attributeCompanion.fromByteBuffer(ByteBuffer.wrap(attributeBytes), constantPool)
  }

}



















