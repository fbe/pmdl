package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
  * Created by becker on 11/29/15.
  */

/*
InnerClasses_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 number_of_classes;
    {   u2 inner_class_info_index;
        u2 outer_class_info_index;
        u2 inner_name_index;
        u2 inner_class_access_flags;
    } classes[number_of_classes];
}
 */

object InnerClassesAttribute extends AttributeInfoFromByteBuffer[InnerClassesAttribute]{

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): InnerClassesAttribute = {

    val innerClassNumber = byteBuffer.getShort()


    val innerClasses = (1 to innerClassNumber).map { _ =>
      InnerClass(byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getShort())
    }.toList

    InnerClassesAttribute(innerClasses)
  }

  override def getAttributeName: String = "InnerClasses"

}

case class InnerClass(innerClassInfoIndex: Short, outerClassInfoIndex: Short, innerNameIndex: Short, innerClassAccessFlags: Short)
case class InnerClassesAttribute(innerClasses: List[InnerClass]) extends AttributeInfo