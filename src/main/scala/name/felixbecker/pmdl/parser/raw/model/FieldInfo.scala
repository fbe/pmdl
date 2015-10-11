package name.felixbecker.pmdl.parser.raw.model

/**
 * Created by becker on 10/11/15.
 */
  /*
field_info {
u2             access_flags;
u2             name_index;
u2             descriptor_index;
u2             attributes_count;
attribute_info attributes[attributes_count];
}
*/
case class FieldInfo(accessFlags: Short, nameIndex: Short, descriptorIndex: Short, attributesCount: Short, attributes: List[AttributeInfo]) extends Traversable[Any] {
  override def foreach[U](f: (Any) => U): Unit = {
    f(accessFlags)
    f(nameIndex)
    f(descriptorIndex)
    f(attributesCount)
    attributes.foreach(f)
  }
}


/*

Attributes are used in the ClassFile, field_info, method_info, and Code_attribute structures (§4.1, §4.5, §4.6, §4.7.3) of the class file format. All attributes have the following general format:

attribute_info {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 info[attribute_length];
}
 */
case class AttributeInfo(attributeNameIndex: Short, attributeLength: Int, attributeBytes: Array[Byte])