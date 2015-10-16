
package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer
import name.felixbecker.pmdl.rawstructure.attributes.code.{Opcode, OpcodeFromBytes}

object ACONST_NULL extends OpcodeFromBytes[ACONST_NULL] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = ACONST_NULL()

  override def byteValue: Byte = 0x1.toByte
}

case class ACONST_NULL() extends Opcode

  