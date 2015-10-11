package name.felixbecker.pmdl.parser.raw

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.constantpool.CPInfo

/**
 * Created by becker on 10/11/15.
 */
trait FromByteBuffer[T <: CPInfo] {
  def fromByteBuffer(byteBuffer: ByteBuffer, constantPoolIndex: Short): T
}
