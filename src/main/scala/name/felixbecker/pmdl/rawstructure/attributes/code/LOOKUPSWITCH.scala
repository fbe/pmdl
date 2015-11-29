package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

object LOOKUPSWITCH extends OpcodeFromBytes[LOOKUPSWITCH] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = {

    val opcodePosition = byteBuffer.position()-1 // offset for jump, jump offsets are relative here, opCodePosition used to make them to absolute jump values inside the code attribute

    // drop padding bytes
    while(byteBuffer.position() % 4 != 0){
      byteBuffer.get()
    }

    val default = byteBuffer.getInt + opcodePosition

    val npairsCount = byteBuffer.getInt


    val npairs = (1 to npairsCount).map(_ => NPair(byteBuffer.getInt(), byteBuffer.getInt() + opcodePosition)).toList

    LOOKUPSWITCH(default, npairs)

  }

  override def byteValue: Byte = 0xab.toByte
}

case class NPair(nMatch: Int, offset: Int)
case class LOOKUPSWITCH(default: Int, npairs: List[NPair]) extends Opcode