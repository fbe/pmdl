package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import name.felixbecker.pmdl.rawstructure.ConstantPool

import scala.annotation.tailrec

class ConstantPoolParser(constantPoolCount: Short) {

  val elementCompanionsByTag = List[FromByteBuffer[_ <: CPInfo] with ConstantPoolElement](
    CPClassTag,
    CPFieldRef,
    CPMethodRef,
    CPInterfaceMethodRef,
    CPStringInfo,
    CPInteger,
    CPFloat,
    CPLong,
    CPDouble,
    CPNameAndType,
    CPUTF8
  ).map { cpElementType =>
    cpElementType.getConstantPoolTag -> cpElementType
  }.toMap


  def parse(bytes: ByteBuffer): ConstantPool = {
    parseRec(Map(), constantPoolCount, 1, bytes)
  }


  @tailrec
  private def parseRec(currentPoolElements: ConstantPool, constantPoolCount: Short, currentIndex: Short, bytes: ByteBuffer): ConstantPool = {

    val elem = getOneConstantPoolElementFromByteBuffer(bytes, currentIndex)
    val newConstantPool = currentPoolElements + (currentIndex -> elem.constantPoolElement)

    if(currentIndex == constantPoolCount-1) // -1 because max constant pool idx == size -1 (defined in spec)
      currentPoolElements + (currentIndex -> elem.constantPoolElement)
    else
      parseRec(newConstantPool, constantPoolCount, (currentIndex + elem.slotCount).toShort, bytes)

  }


  sealed case class ConstantPoolElementAndSlotCount(constantPoolElement: CPInfo, slotCount: Short)

  private def getOneConstantPoolElementFromByteBuffer(byteBuffer : ByteBuffer, currentSlotIndex: Short) = {

    val tag = byteBuffer.get()

    val cpElementCompanion = elementCompanionsByTag.getOrElse(tag, throw new RuntimeException(s"Cannot parse constant pool - no Element with tag $tag known!"))

    val elem = cpElementCompanion.fromByteBuffer(byteBuffer, currentSlotIndex)

    ConstantPoolElementAndSlotCount(elem, cpElementCompanion.requiredSlots)

  }

}
