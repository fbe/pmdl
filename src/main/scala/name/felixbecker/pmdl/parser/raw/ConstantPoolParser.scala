package name.felixbecker.pmdl.parser.raw

import java.nio.ByteBuffer
import java.util


trait CPInfo {
  def cpIndex: Short

  def toStringInternal: String

  override def toString = {
    val formattedCpIndex = "%05d".format(cpIndex)
    val simpleClassName = getClass.getSimpleName.substring(2)
    s"[$formattedCpIndex] $simpleClassName - $toStringInternal"
  }
}
case class CPClassTag(cpIndex: Short, nameIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Name: $nameIndex"
}

case class CPFieldRef(cpIndex: Short, classIndex: Short, nameAndTypeIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Class: $classIndex, NameAndType: $nameAndTypeIndex"
}

case class CPMethodref(cpIndex: Short, classIndex: Short, nameAndType: Short) extends CPInfo {
  override def toStringInternal: String = s"Class: $classIndex, NameAndType: $nameAndType"
}

case class CPInterfaceMethodRef(cpIndex: Short, classIndex: Short, nameAndTypeIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Class: $classIndex, NameAndType: $nameAndTypeIndex"
}

case class CPString(cpIndex: Short, stringIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"String: $stringIndex"
}

case class CPInteger(cpIndex: Short, value: Int) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

case class CPLong(cpIndex: Short, value: Long) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

case class CPFloat(cpIndex: Short, value: Float) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

case class CPDouble(cpIndex: Short, value: Double) extends CPInfo {
  override def toStringInternal: String = s"$value"
}

case class CPUnusedSlot(cpIndex: Short) extends CPInfo {
  override def toStringInternal: String = " X "
}// Used for doubles / longs

case class CPNameAndType(cpIndex: Short, nameIndex: Short, descriptorIndex: Short) extends CPInfo {
  override def toStringInternal: String = s"Name: $nameIndex, Descriptor: $descriptorIndex"
}

case class CPUTF8(cpIndex: Short, value: String) extends CPInfo {
  override def toStringInternal: String = s"'$value'"
}

object CPInfo {

  val ClassTag = 7
  val Fieldref = 9
  val Methodref = 10
  val InterfaceMethodRef = 11
  val String = 8
  val Integer = 3
  val Float = 4
  val Long = 5
  val Double = 6
  val NameAndType = 12
  val Utf8 = 1
  val MethodHandle = 15
  val MethodType = 16
  val InvokeDynamic = 18

}

class ConstantPoolParser(constantPoolCount: Short) extends RawParser[List[CPInfo]] {

  override def parse(bytes: ByteBuffer): List[CPInfo] = {

//    println(s"Elements in Constant pool $constantPoolCount")

    val elements = new util.ArrayList[CPInfo]()

    var idx: Short = 1

    while(idx <= constantPoolCount) {

      val tag = bytes.get()

      tag match {

        case CPInfo.ClassTag =>

          /*
            CONSTANT_Class_info {
              u1 tag;
              u2 name_index;
            }
        */

          val nameIndex = bytes.getShort
          elements.add(CPClassTag(idx, nameIndex))

        case CPInfo.Fieldref =>

          /*
            CONSTANT_Fieldref_info {
              u1 tag;
              u2 class_index;
              u2 name_and_type_index;
            }
         */

          val classIndex = bytes.getShort
          val nameAndTypeIndex = bytes.getShort
          elements.add(CPFieldRef(idx, classIndex, nameAndTypeIndex))

        case CPInfo.Methodref =>

          /*
            CONSTANT_Methodref_info {
              u1 tag;
              u2 class_index;
              u2 name_and_type_index;
            }
         */

          val classIndex = bytes.getShort
          val nameAndType = bytes.getShort

          elements.add(CPMethodref(idx, classIndex, nameAndType))

        case CPInfo.InterfaceMethodRef =>

          /*

              CONSTANT_InterfaceMethodref_info {
                u1 tag;
                u2 class_index;
                u2 name_and_type_index;
              }

          */

          val classIndex = bytes.getShort
          val nameAndTypeIndex = bytes.getShort
          elements.add(CPInterfaceMethodRef(idx, classIndex, nameAndTypeIndex))

        case CPInfo.String =>
          val stringIndex = bytes.getShort
          elements.add(CPString(idx, stringIndex))
          
        case CPInfo.Integer =>

          /*
            CONSTANT_Integer_info {
              u1 tag;
              u4 bytes;
            }
         */
          val intValue = bytes.getInt()
          elements.add(CPInteger(idx, intValue))

        case CPInfo.Float =>

          val floatValue = bytes.getFloat
          elements.add(CPFloat(idx, floatValue))

        case CPInfo.Long =>

          /*
              CONSTANT_Long_info {
                u1 tag;
                u4 high_bytes;
                u4 low_bytes;
              }
           */

          val longValue = bytes.getLong
          elements.add(CPLong(idx, longValue))
          idx = (idx+1).toShort
          elements.add(CPUnusedSlot(idx))

        case CPInfo.Double =>

          /*
            CONSTANT_Double_info {
              u1 tag;
              u4 high_bytes;
              u4 low_bytes;
            }
        */


          val doubleValue = bytes.getDouble()
          elements.add(CPDouble(idx, doubleValue))
          idx = (idx+1).toShort
          elements.add(CPUnusedSlot(idx)) // add unused slot


        case CPInfo.NameAndType =>

          /*
            CONSTANT_NameAndType_info {
              u1 tag;
              u2 name_index;
              u2 descriptor_index;
            }
         */

          val nameIndex = bytes.getShort
          val descriptorIndex = bytes.getShort
          elements.add(CPNameAndType(idx, nameIndex, descriptorIndex))

        case CPInfo.Utf8 =>

          /*
            CONSTANT_Utf8_info {
              u1 tag;
              u2 length;
              u1 bytes[length];
            }
         */

          val length = bytes.getShort

          // TODO Clean up please
          val stringBytes: Array[Byte] = (1 to length).map { _ =>
            bytes.get
          }.toArray

          elements.add(CPUTF8(idx, new String(stringBytes)))

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
