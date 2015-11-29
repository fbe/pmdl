package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/21/15.
 */
object TABLESWITCH extends OpcodeFromBytes[TABLESWITCH] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = {

    val opcodePosition = byteBuffer.position()-1 // offset for jump, jump offsets are relative here, opCodePosition used to make them to absolute jump values inside the code attribute

    // DROP padding bytes
    while(byteBuffer.position() % 4 != 0){
      byteBuffer.get()
    }

    val default = byteBuffer.getInt() + opcodePosition
    val low = byteBuffer.getInt()
    val high = byteBuffer.getInt()

    val tableEntries = (low to high).map(x => x -> (byteBuffer.getInt()+opcodePosition)).toMap

    TABLESWITCH(default, low, high,tableEntries)
  }

  override def byteValue: Byte = 0xaa.toByte
}

case class TABLESWITCH(default: Int, low: Int, high: Int, tableEntries: Map[Int, Int]) extends Opcode


