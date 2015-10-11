package name.felixbecker.pmdl.rawstructure.fields

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.attributes.AttributeInfo

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

class FieldInfoParser(fieldCount: Short) {

  def parse(bytes: ByteBuffer): List[FieldInfo] = {

    (1 to fieldCount).map { _ =>
      val accessFlags = bytes.getShort()
      val nameIndex = bytes.getShort()
      val descriptorIndex = bytes.getShort()
      val attributesCount = bytes.getShort()
      val attributes = new AttributeParser(attributesCount).parse(bytes)
      FieldInfo(accessFlags, nameIndex, descriptorIndex, attributesCount, attributes)
    }.toList

  }

}

/*
  attribute_info {
  u2 attribute_name_index;
  u4 attribute_length;
  u1 info[attribute_length];
}
*/
class AttributeParser(attributesCount: Short) {

  def parse(bytes: ByteBuffer): List[AttributeInfo] = {

    (1 to attributesCount).map { _ =>
      val attributeNameIndex = bytes.getShort()
      val attributeLength = bytes.getInt()
      val attributeBytes = (1 to attributeLength).map { _ => bytes.get()}.toArray
      AttributeInfo(attributeNameIndex, attributeLength, attributeBytes)
    }.toList

  }
}