package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer


/**
 * Created by becker on 10/11/15.
 */
case class CPClassTag(cpIndex: Short, nameIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Name: $nameIndex"
}
object CPClassTag extends FromByteBuffer[CPClassTag] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPClassTag = {
    /*
  CONSTANT_Class_info {
    u1 tag;
    u2 name_index;
  }
*/

    val nameIndex = byteBuffer.getShort
    CPClassTag(constantPoolIndex, nameIndex)
  }

  override def getConstantPoolTag: Byte = 7
}