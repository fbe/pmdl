package name.felixbecker.pmdl

import java.nio.ByteBuffer

/**
  * Created by becker on 1/30/17.
  */
object ByteHelper {
  implicit class ByteBufferExtensions(byteBuffer: ByteBuffer){

    def getUnsignedShort: Int = {
      byteBuffer.getShort & 0xFFFF
    }


    /*
    Short:

11111111 11111110  // signed: -2

Int
11111111 11111111 11111111 11111110 // signed -2


&
00000000 00000000 11111111 11111111 // & 0xFFFF

-----------------------------------
00000000 00000000 11111111 11111110


~                                                              
     */

  }
}
