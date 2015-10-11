package name.felixbecker.pmdl.rawstructure.methods

import name.felixbecker.pmdl.rawstructure.AccessFlags
import name.felixbecker.pmdl.rawstructure.attributes.AttributeInfo

/**
 * Created by becker on 10/11/15.
 */

/*
method_info {
    u2             access_flags;
    u2             name_index;
    u2             descriptor_index;
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
 */
case class MethodInfo(accessFlags: Short, nameIndex: Short, descriptorIndex: Short, attributesCount: Short, attributes: List[AttributeInfo]){
  override def toString: String =
    s"""
      | MethodInfo:
      |   Access Flags: ${AccessFlags.shortToAccessFlags(accessFlags, AccessFlags.MethodAccessFlags).map(_.name).mkString(", ")}
      |   Name Index: $nameIndex
      |   Descriptor Index: $descriptorIndex
      |   Attributes count: $attributesCount
      |   ${attributes.mkString("\n    ")}""".stripMargin
}
