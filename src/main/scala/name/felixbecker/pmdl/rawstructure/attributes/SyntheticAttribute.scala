package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/*
Synthetic_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
}
 */

object SyntheticAttribute extends AttributeInfoFromByteBuffer[SyntheticAttribute]{

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): SyntheticAttribute = {
    SyntheticAttribute()
  }

  override def getAttributeName: String = "Synthetic"

}

case class SyntheticAttribute() extends AttributeInfo
