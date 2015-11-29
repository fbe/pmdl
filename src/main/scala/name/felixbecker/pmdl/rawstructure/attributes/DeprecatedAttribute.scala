package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/*
Deprecated_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
}
 */

object DeprecatedAttribute extends AttributeInfoFromByteBuffer[DeprecatedAttribute]{

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): DeprecatedAttribute = {
    DeprecatedAttribute()
  }

  override def getAttributeName: String = "Deprecated"

}

case class DeprecatedAttribute() extends AttributeInfo