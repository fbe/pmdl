package name.felixbecker.pmdl.rawstructure.fields

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.attributes.AttributeInfo
import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

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

class FieldInfoParser(fieldCount: Short, constantPool: ConstantPool) {

  def parse(bytes: ByteBuffer): List[FieldInfo] = {

    (1 to fieldCount).map { _ =>
      val accessFlags = bytes.getShort()
      val nameIndex = bytes.getShort()
      val descriptorIndex = bytes.getShort()
      val attributesCount = bytes.getShort()
      val attributes = AttributeInfo.fromByteBuffer(bytes, attributesCount, constantPool)
      FieldInfo(accessFlags, nameIndex, descriptorIndex, attributesCount, attributes)
    }.toList

  }

}

