package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object SourceFileAttribute {

  /*

  SourceFile_attribute {
X   u2 attribute_name_index;
X   u4 attribute_length;
    u2 sourcefile_index;
  }

  */
  def parseFromByteBuffer(bytes: ByteBuffer, constantPool: ConstantPool): Unit = {
    val sourceFileIndex = bytes.getShort()
    println(s"SourceFile index: $sourceFileIndex")
  }
}
