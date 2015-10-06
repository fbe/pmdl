package name.felixbecker.pmdl.parser.raw

import java.nio.ByteBuffer
import java.util

import name.felixbecker.pmdl.parser.raw.model.CPInfo


case class CPClassTag(cpIndex: Short, nameIndex: Short) extends CPInfo
case class CPFieldRef(cpIndex: Short, classIndex: Short, nameAndTypeIndex: Short) extends CPInfo
case class CPMethodref(cpIndex: Short, classIndex: Short, nameAndType: Short) extends CPInfo
case class CPInterfaceMethodRef(cpIndex: Short, classIndex: Short, nameAndTypeIndex: Short) extends CPInfo
case class CPString(cpIndex: Short, stringIndex: Short) extends CPInfo
case class CPInteger(cpIndex: Short, value: Int) extends CPInfo
case class CPLong(cpIndex: Short, value: Long) extends CPInfo
case class CPFloat(cpIndex: Short, value: Float) extends CPInfo
case class CPDouble(cpIndex: Short, value: Double) extends CPInfo
case class CPUnusedSlot(cpIndex: Short) extends CPInfo // Used for doubles / longs
case class CPNameAndType(cpIndex: Short, nameIndex: Short, descriptorIndex: Short) extends CPInfo
case class CPUTF8(cpIndex: Short, value: String) extends CPInfo

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

        case CPInfo.Double =>

          /*
            CONSTANT_Double_info {
              u1 tag;
              u4 high_bytes;
              u4 low_bytes;
            }
        */


          idx = (idx+1).toShort
          val doubleValue = bytes.getDouble()
          elements.add(CPDouble(idx, doubleValue))
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
          println(s"[$idx] MethodHandle: ")
        // TODO implement (and check if used by the java compiler)
        case CPInfo.MethodType =>
          println(s"[$idx] MethodType: ")
        // TODO implement (and check if used by the java compiler)
        case CPInfo.InvokeDynamic =>
          println(s"[$idx] InvokeDynamic: ")
        // TODO implement (and check if used by the java compiler)
      }

      idx = (idx+1).toShort
    }

    import scala.collection.JavaConversions._
    elements.toList
  }

}
