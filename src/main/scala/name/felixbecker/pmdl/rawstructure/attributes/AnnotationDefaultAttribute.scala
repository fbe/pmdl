package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/*
AnnotationDefault_attribute {
    u2            attribute_name_index;
    u4            attribute_length;
    element_value default_value;
}
 */

object AnnotationDefaultAttribute extends AttributeInfoFromByteBuffer[AnnotationDefaultAttribute] {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): AnnotationDefaultAttribute = {
    println("TODO implement me AnnotationDefaultAttribute")
    AnnotationDefaultAttribute()
  }

  override def getAttributeName: String = "AnnotationDefault"
}

case class AnnotationDefaultAttribute() extends AttributeInfo
