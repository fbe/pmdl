package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

/**
 * Created by becker on 10/13/15.
 */
object SourceFileAttribute extends AttributeInfoFromByteBuffer[SourceFileAttribute] {

  /*

  SourceFile_attribute {
X   u2 attribute_name_index;
X   u4 attribute_length;
    u2 sourcefile_index;
  }

  */
  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): SourceFileAttribute = {
    val sourceFileIndex = byteBuffer.getShort()
    SourceFileAttribute(sourceFileIndex)
  }


  override def getAttributeName: String = "SourceFile"
}

case class SourceFileAttribute(sourceFileIndex: Short) extends AttributeInfo