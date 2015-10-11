package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

private[constantpool] trait FromByteBuffer[T <: CPInfo] {
  def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): T
}
