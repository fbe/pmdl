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
    val numAnnotations = byteBuffer.getShort
    println(s"TODO Implement me RuntimeVisibleAnnotations - byte buffer length: ${byteBuffer.capacity()} - numAnnotations: $numAnnotations")
    (1 to numAnnotations).foreach { num =>
      val typeIdx = byteBuffer.getShort()
      val numElementValuePairs = byteBuffer.getShort()
      println(s"Num Element value pairs: $numElementValuePairs")
      (1 to numElementValuePairs).foreach { n =>
        val elementNameIdx = byteBuffer.getShort()
        val tag = byteBuffer.get()
        println(s"In constant pool (by elementNameIdx: ${constantPool.elements(elementNameIdx)})")
        println(s"Tag: ${new String(Array(tag))}")
      }

    }
    RuntimeVisibleAnnotationsParameterAttribute()
  }

  override def getAttributeName: String = "RuntimeVisibleAnnotations"

}

case class RuntimeVisibleAnnotationsParameterAttribute() extends AttributeInfo
