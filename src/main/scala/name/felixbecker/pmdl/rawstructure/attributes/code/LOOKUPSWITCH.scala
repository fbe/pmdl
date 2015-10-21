package name.felixbecker.pmdl.rawstructure.attributes.code

import java.nio.ByteBuffer

/**
 * Created by becker on 10/21/15.
 */
object LOOKUPSWITCH extends OpcodeFromBytes[LOOKUPSWITCH] {

  override def parseFromByte(byteBuffer: ByteBuffer): Opcode = {

    println("Lookup switch parsing")

    println(s"Byte buffer - position: ${byteBuffer.position()}/${byteBuffer.capacity()} (remaining: ${byteBuffer.remaining()})")

    val copy = byteBuffer.duplicate()
    val bytes = (1 to 20).map(x => copy.get()).grouped(4).map(byteGroup => byteGroup.map(b => "0x%02x".format(b)).mkString(" ")).mkString("\n")

    println(s"Next 20 bytes:\n$bytes")

    val offset = 2
    // Skipping offset
    (1 to offset).foreach(_ => byteBuffer.get())

    val defaultByte1 = byteBuffer.get()
    val defaultByte2 = byteBuffer.get()
    val defaultByte3 = byteBuffer.get()
    val defaultByte4 = byteBuffer.get()

    val npairs = byteBuffer.getInt

    println(s"N Pairs: $npairs")

    throw new RuntimeException("yaya bin con LOOKUPSWITCH")
    //LOOKUPSWITCH()
  }

  override def byteValue: Byte = 0xab.toByte
}

case class LOOKUPSWITCH() extends Opcode


