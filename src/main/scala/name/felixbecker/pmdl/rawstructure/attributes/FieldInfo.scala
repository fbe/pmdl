package name.felixbecker.pmdl.rawstructure.attributes




/*

Attributes are used in the ClassFile, field_info, method_info, and Code_attribute structures (§4.1, §4.5, §4.6, §4.7.3) of the class file format. All attributes have the following general format:

attribute_info {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 info[attribute_length];
}
 */
case class AttributeInfo(attributeNameIndex: Short, attributeLength: Int, attributeBytes: Array[Byte]){
  override def toString: String =
    s"""
      | Attribute:
      |   Attribute name index: $attributeNameIndex
      |   Attribute length: $attributeLength
      |   ... some bytes (Parse me =))""".stripMargin
}