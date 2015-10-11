package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer
import java.util

import name.felixbecker.pmdl.parser.raw.{FromByteBuffer, RawParser}
import name.felixbecker.pmdl.rawstructure.ConstantPool

class ConstantPoolParser(constantPoolCount: Short) extends RawParser[ConstantPool] {

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


  override def parse(bytes: ByteBuffer): ConstantPool = {

    val elements = new util.ArrayList[CPInfo]()

    var idx: Short = 1

    while (idx <= constantPoolCount) {

      val tag = bytes.get()

      val cpElementCompanion = elementCompanionsByTag.getOrElse(tag, throw new RuntimeException(s"Cannot parse constant pool - no Element with tag $tag known!"))

      elements.add(cpElementCompanion.fromByteBuffer(bytes, idx))

      idx = (idx + cpElementCompanion.requiredSlots).toShort
    }

    import scala.collection.JavaConversions._
    elements.map { e => e.cpIndex -> e }.toMap
  }

}
