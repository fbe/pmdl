package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/*
RuntimeInvisibleParameterAnnotations_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 num_parameters;
    {   u2         num_annotations;
        annotation annotations[num_annotations];
    } parameter_annotations[num_parameters];
}
 */

object RuntimeInvisibleParameterAnnotationsAttribute extends AttributeInfoFromByteBuffer[RuntimeInvisibleParameterAnnotationsAttribute]{

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): RuntimeInvisibleParameterAnnotationsAttribute = {
    val numParameters = byteBuffer.get()
    val numAnnotations = byteBuffer.getShort()

    println(s"TODO Implement me RuntimeInvisibleParameterAnnotations NumParameters - $numParameters numAnnotations $numAnnotations")
    RuntimeInvisibleParameterAnnotationsAttribute(Nil)
  }

  override def getAttributeName: String = "RuntimeInvisibleParameterAnnotations"

}

case class ParameterAnnotation()
case class RuntimeInvisibleParameterAnnotationsAttribute(parameterAnnotations: List[ParameterAnnotation]) extends AttributeInfo


