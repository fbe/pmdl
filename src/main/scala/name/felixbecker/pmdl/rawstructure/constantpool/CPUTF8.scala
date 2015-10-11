package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.parser.raw.FromByteBuffer

object CPUTF8 extends FromByteBuffer[CPUTF8] with ConstantPoolElement {

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): CPUTF8 = {
    /*
      CONSTANT_Utf8_info {
        u1 tag;
        u2 length;
        u1 bytes[length];
      }
    */

    val length = byteBuffer.getShort

    // TODO Clean up please
    val stringBytes: Array[Byte] = (1 to length).map { _ =>
      byteBuffer.get
    }.toArray
    CPUTF8(constantPoolIndex, new String(stringBytes))
  }

  override def getConstantPoolTag: Byte = 1
}

case class CPUTF8(cpIndex: Short, value: String) extends CPInfo {
  override def toStringInternal: String = s"'$value'"
}
