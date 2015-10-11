package name.felixbecker.pmdl.rawstructure.fields

import name.felixbecker.pmdl.rawstructure.AccessFlags
import name.felixbecker.pmdl.rawstructure.attributes.AttributeInfo

/**
 * Created by becker on 10/11/15.
 */
  /*
field_info {
u2             access_flags;
u2             name_index;
u2             descriptor_index;
u2             attributes_count;
attribute_info attributes[attributes_count];
}
*/
case class FieldInfo(accessFlags: Short, nameIndex: Short, descriptorIndex: Short, attributesCount: Short, attributes: List[AttributeInfo]) extends Traversable[Any] {

  override def foreach[U](f: (Any) => U): Unit = {
    f(accessFlags)
    f(nameIndex)
    f(descriptorIndex)
    f(attributesCount)
    attributes.foreach(f)
  }

  override def toString(): String = {

    s"""
      | FieldInfo:
      |   Access flags: ${AccessFlags.shortToAccessFlags(accessFlags, AccessFlags.FieldAccessFlags).map(_.name).mkString(", ")}
      |   Name index: $nameIndex
      |   Descriptor index: $descriptorIndex
      |   Attributes count: $attributesCount
      |   Attributes:
      |     ${attributes.mkString("\n     ")}""".stripMargin
  }
}
