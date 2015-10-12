package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer

import scala.annotation.tailrec

case class ConstantPool(elements: Map[Short, CPInfo]) extends Traversable[Any] {

  override def foreach[U](f: (Any) => U): Unit = {
    elements.values.foreach(f)
  }

  def getString(index: Short): String = {
    elements.getOrElse(index, throw new RuntimeException(s"Constant pool element on index $index not found!")) match {
      case x : CPUTF8 => x.value
      case unknown => throw new RuntimeException(s"Requested a CPUTF8 String from constant pool index $index - another type found: $unknown")
    }
  }

}

object ConstantPool {

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


  @tailrec
  private def parseRec(currentPoolElements: Map[Short, CPInfo], constantPoolCount: Short, currentIndex: Short, bytes: ByteBuffer): Map[Short, CPInfo] = {

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


  def parseFromByteBuffer(byteBuffer: ByteBuffer, constantPoolCount: Short): ConstantPool = {
    ConstantPool(parseRec(Map(), constantPoolCount, 1, byteBuffer))
  }
}

