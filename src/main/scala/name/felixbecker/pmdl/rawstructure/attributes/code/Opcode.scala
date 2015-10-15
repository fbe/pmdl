package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer












trait Opcode

object Opcode {


  val opcodeCompanions: Map[Byte, OpcodeFromBytes[_ <: Opcode]] = List (
    AALOAD,
    AASTORE,
    ALOAD0,
    INVOKESPECIAL,
    LDC2W,
    PUTFIELD,
    LDC,
    BIPUSH,
    ICONST0,
    ALOAD1,
    RETURN,
    GETSTATIC,
    INVOKEVIRTUAL,
    GETFIELD,
    INVOKEINTERFACE,
    GOTO,
    ASTORE1,
    NEW,
    DUP,
    ATHROW,
    ARETURN,
    ICONST2,
    IREM,
    IFNE
  ).map(companion => companion.byteValue -> companion).toMap

  private def parseSingleOpcode(byteBuffer: ByteBuffer): Opcode = {

    val opCodeByteValue = byteBuffer.get()
    val companion = opcodeCompanions.getOrElse(opCodeByteValue, throw new RuntimeException(s"Unknown opcode 0x${"%02x".format(opCodeByteValue)}"))

    companion.parseFromByte(byteBuffer)

  }


  def parseFromByteBuffer(byteBuffer: ByteBuffer, alreadyParsed: List[Opcode] = Nil): List[Opcode] = {

    if(byteBuffer.hasRemaining){

      val newParsed = parseSingleOpcode(byteBuffer)

      parseFromByteBuffer(byteBuffer, alreadyParsed :+ newParsed)
    } else {
      alreadyParsed
    }
  }
}









