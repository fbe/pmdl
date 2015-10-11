package name.felixbecker.pmdl.parser.raw

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.model.AttributeInfo

/**
 * Created by becker on 10/11/15.
 */

/*
method_info {
    u2             access_flags;
    u2             name_index;
    u2             descriptor_index;
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
 */
case class MethodInfo(accessFlags: Short, nameIndex: Short, descriptorIndex: Short, attributesCount: Short, attributes: List[AttributeInfo])

class MethodInfoParser(methodsCount: Short) {
  def parse(bytes: ByteBuffer): List[MethodInfo] = {

    (1 to methodsCount).map { _ =>

      val accessFlags = bytes.getShort()
      val nameIndex = bytes.getShort()
      val descriptorIndex = bytes.getShort()
      val attributesCount = bytes.getShort()
      val attributes = new AttributeParser(attributesCount).parse(bytes)

      MethodInfo(accessFlags, nameIndex, descriptorIndex, attributesCount, attributes)

    }.toList
  }
}
