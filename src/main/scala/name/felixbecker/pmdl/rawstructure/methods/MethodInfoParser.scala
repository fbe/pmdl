package name.felixbecker.pmdl.rawstructure.methods

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.attributes.AttributeInfo
import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool


class MethodInfoParser(methodsCount: Short) {

  def parse(bytes: ByteBuffer, constantPool: ConstantPool): List[MethodInfo] = {

    (1 to methodsCount).map { _ =>

      val accessFlags = bytes.getShort()
      val nameIndex = bytes.getShort()
      val descriptorIndex = bytes.getShort()
      val attributesCount = bytes.getShort()
      val attributes = AttributeInfo.fromByteBuffer(bytes, attributesCount, constantPool)

      MethodInfo(accessFlags, nameIndex, descriptorIndex, attributesCount, attributes)

    }.toList

  }
}
