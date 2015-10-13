package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object RuntimeInvisibleAnnotationsAttribute extends AttributeInfoFromByteBuffer[RuntimeInvisibleAnnotationsAttribute] {
  /*
  RuntimeInvisibleAnnotations_attribute {
X   u2         attribute_name_index;
X   u4         attribute_length;
    u2         num_annotations;
    annotation annotations[num_annotations];
  }
 */

  /*
  annotation {
  u2 type_index;
  u2 num_element_value_pairs;
  {   u2            element_name_index;
      element_value value;
  } element_value_pairs[num_element_value_pairs];
}

   */

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): RuntimeInvisibleAnnotationsAttribute = {

    val numAnnotations = byteBuffer.getShort()

    RuntimeInvisibleAnnotationsAttribute(numAnnotations, byteBuffer)

  }

  override def getAttributeName: String = "RuntimeInvisibleAnnotations"
}
case class RuntimeInvisibleAnnotationsAttribute(numAnnotations: Short, remainingUnparsedBytes: ByteBuffer) extends AttributeInfo
