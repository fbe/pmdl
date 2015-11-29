package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool


/*
RuntimeVisibleAnnotations_attribute {
    u2         attribute_name_index;
    u4         attribute_length;
    u2         num_annotations;
    annotation annotations[num_annotations];
}
 */

object RuntimeVisibleAnnotationsParameterAttribute extends AttributeInfoFromByteBuffer[RuntimeVisibleAnnotationsParameterAttribute]{

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): RuntimeVisibleAnnotationsParameterAttribute = {


    println("TODO Implement me RuntimeVisibleAnnotations")
    RuntimeVisibleAnnotationsParameterAttribute()
  }

  override def getAttributeName: String = "RuntimeVisibleAnnotations"

}

case class RuntimeVisibleAnnotationsParameterAttribute() extends AttributeInfo
