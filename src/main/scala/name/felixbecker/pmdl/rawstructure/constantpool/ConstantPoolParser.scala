package name.felixbecker.pmdl.rawstructure.constantpool

import java.nio.ByteBuffer
import java.util

import name.felixbecker.pmdl.parser.raw.RawParser

/**
 * Created by becker on 10/11/15.
 */
class ConstantPoolParser(constantPoolCount: Short) extends RawParser[List[CPInfo]] {

  override def parse(bytes: ByteBuffer): List[CPInfo] = {

//    println(s"Elements in Constant pool $constantPoolCount")

    val elements = new util.ArrayList[CPInfo]()

    var idx: Short = 1

    while(idx <= constantPoolCount) {

      val tag = bytes.get()

      tag match {

        case CPInfo.ClassTag => elements.add(CPClassTag.fromByteBuffer(bytes, idx))

        case CPInfo.Fieldref => elements.add(CPFieldRef.fromByteBuffer(bytes, idx))

        case CPInfo.Methodref => elements.add(CPMethodref.fromByteBuffer(bytes, idx))

        case CPInfo.InterfaceMethodRef => elements.add(CPInterfaceMethodRef.fromByteBuffer(bytes, idx))

        case CPInfo.String => elements.add(CPString.fromByteBuffer(bytes, idx))

        case CPInfo.Integer => elements.add(CPInteger.fromByteBuffer(bytes, idx))

        case CPInfo.Float => elements.add(CPFloat.fromByteBuffer(bytes, idx))

        case CPInfo.Long =>
          elements.add(CPLong.fromByteBuffer(bytes, idx))
          idx = (idx+1).toShort


        case CPInfo.Double =>
          elements.add(CPDouble.fromByteBuffer(bytes, idx))
          idx = (idx+1).toShort

        case CPInfo.NameAndType => elements.add(CPNameAndType.fromByteBuffer(bytes, idx))

        case CPInfo.UTF8 => elements.add(CPUTF8.fromByteBuffer(bytes, idx))

        case CPInfo.MethodHandle =>
          throw new NotImplementedError("Parsing method handles not implemented")  // TODO
        case CPInfo.MethodType =>
          throw new NotImplementedError("Parsing method type not implemented")  // TODO
        case CPInfo.InvokeDynamic =>
          throw new NotImplementedError("Parsing invoke dynamic not implemented")  // TODO
      }

      idx = (idx+1).toShort
    }

    import scala.collection.JavaConversions._
    elements.toList
  }

}
