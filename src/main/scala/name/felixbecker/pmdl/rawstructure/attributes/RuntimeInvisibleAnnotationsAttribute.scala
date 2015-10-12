package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
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
