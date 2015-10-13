package name.felixbecker.pmdl.rawstructure.attributes

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.ConstantPool

trait AttributeInfoFromByteBuffer[T <: AttributeInfo] {
  def fromByteBuffer(byteBuffer: ByteBuffer, constantPool: ConstantPool): T
  def getAttributeName: String
}
