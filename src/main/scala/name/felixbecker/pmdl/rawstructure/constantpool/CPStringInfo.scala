package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

/*
  CONSTANT_String_info {
    u1 tag;
    u2 string_index;
  }
*/

case class CPStringInfo(cpIndex: Short, stringIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"String: $stringIndex"
}

object CPStringInfo extends CPElementFromByteBuffer[CPStringInfo] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPStringInfo = {

    val stringIndex = byteBuffer.getShort
    CPStringInfo(constantPoolIndex, stringIndex)

  }

  override def getConstantPoolTag: Byte = 8

}
