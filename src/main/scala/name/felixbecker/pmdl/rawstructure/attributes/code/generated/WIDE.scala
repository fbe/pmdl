package name.felixbecker.pmdl.rawstructure.attributes.code.generated

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.attributes.code.{OpcodeFromBytes, Opcode}

object WIDE extends OpcodeFromBytes[WIDE] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = {

    val opcode = byteBuffer.get()

    WIDE(
      opcode,
      byteBuffer.get(),
      byteBuffer.get(),
      if(opcode == IINC.byteValue) Some(byteBuffer.get()) else None,
      if(opcode == IINC.byteValue) Some(byteBuffer.get()) else None
    )

  }

  override def byteValue: Byte = 0xc4.toByte
}

/**
 * @param opcode
 * @param indexByte1
 * @param indexByte2
 * @param constByte1 defined if opcode is IINC
 * @param constByte2 defined if opcode is IINC
 */
case class WIDE(opcode: Byte, indexByte1: Byte, indexByte2: Byte, constByte1: Option[Byte], constByte2: Option[Byte]) extends Opcode