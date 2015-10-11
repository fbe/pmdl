package name.felixbecker.pmdl.rawstructure.methods

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.fields.AttributeParser


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
