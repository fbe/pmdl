package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object ConstantValueAttribute {
/*
ConstantValue_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 constantvalue_index;
}
 */
  def parseFromByteBuffer(bytes: ByteBuffer, constantPool: ConstantPool): Unit = {
    val constantValueIndex = bytes.getShort()
    println(s"ConstantValueAttribute - constantValueIndex: $constantValueIndex")
  }
}
