package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

object SignatureAttribute extends AttributeInfoFromByteBuffer[SignatureAttribute] {

  /*
Signature_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 signature_index;
}
 */

  override def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): SignatureAttribute =  {
    val signatureIndex = byteBuffer.getShort()
    SignatureAttribute(signatureIndex)
  }

  override def getAttributeName: String = "Signature"
}

case class SignatureAttribute(signatureIndex: Short) extends AttributeInfo