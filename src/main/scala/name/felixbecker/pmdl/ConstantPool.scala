package name.felixbecker.pmdl

import java.nio.ByteBuffer

/**
 * Created by becker on 10/5/15.
 */
object ConstantPool {

  def parseCpInfo(bytes: ByteBuffer, constantPoolCount: Int): Unit ={

    println(s"Elements in Constant pool $constantPoolCount")

    var idx = 1

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
          println(s"[$idx] ClassTag name_idx $nameIndex")

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
          println(s"[$idx] Fieldref classIndex: $classIndex, name_and_type_index: $nameAndTypeIndex")

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

          println(s"[$idx] MethodRef: Class Index: $classIndex, NameAndType: $nameAndType")

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

          println(s"[$idx] InterfaceMethodRef: classIndex: $classIndex, nameAndTypeIndex: $nameAndTypeIndex")

        case CPInfo.String =>
          val stringIndex = bytes.getShort
          println(s"[$idx] String: Index: $stringIndex")

        case CPInfo.Integer =>

          /*
            CONSTANT_Integer_info {
              u1 tag;
              u4 bytes;
            }
         */

          println(s"[$idx] Integer: ${bytes.getInt} ")

        case CPInfo.Float =>

          val float = bytes.getFloat
          println(s"[$idx] Float: $float")

        case CPInfo.Long =>

          /*
              CONSTANT_Long_info {
                u1 tag;
                u4 high_bytes;
                u4 low_bytes;
              }
           */

          val long = bytes.getLong

          println(s"[$idx] Long: $long")

        case CPInfo.Double =>

          /*
            CONSTANT_Double_info {
              u1 tag;
              u4 high_bytes;
              u4 low_bytes;
            }
        */


          println(s"[$idx] Double: " + bytes.getDouble)
          idx = idx+1
          println(s"[$idx] Double reserved slot - unused")


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

          println(s"[$idx] NameAndType: nameIndex: $nameIndex, descriptorIndex: $descriptorIndex")

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

          val stringBytesAsString = new String(stringBytes)

          println(s"[$idx] Utf8: length: $length - bytes: $stringBytesAsString")

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

      idx = idx+1
    }

  }
}
