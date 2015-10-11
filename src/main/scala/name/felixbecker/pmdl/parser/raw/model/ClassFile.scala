package name.felixbecker.pmdl.parser.raw.model

import name.felixbecker.pmdl.parser.raw.{CPInfo, AccessFlag, MethodInfo}

// Representation of a raw class file, defined in https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html

case class ClassFile(
                      magicNumber: Int,
                      minorVersion: Short,
                      majorVersion: Short,
                      constantPoolCount: Short,
                      cpInfos: List[CPInfo],
                      accessFlags: List[AccessFlag],
                      thisClass: Short,
                      superClass: Short,
                      interfacesCount:Short,
                      interfaces: List[Short],
                      fieldCount: Short,
                      fields: List[FieldInfo],
                      methodsCount: Short,
                      methods: List[MethodInfo],
                      attributesCount: Short,
                      attributes: List[AttributeInfo]


                      ) extends Traversable[Any] {



  override def toString: String = {
    val magicNumberAsString: String = "0x%02X".format(magicNumber)
    s"""
       | Magic number: $magicNumberAsString
       | Version: $majorVersion.$minorVersion
       | Constant pool count: $constantPoolCount
       | Access Flags: ${accessFlags.map(_.name).mkString(", ")}
       | This class: $thisClass (cp index)
       | Super class: $superClass (cp index)
       | Interfaces count: $interfacesCount
       | Field count: $fieldCount
       | Method count: $methodsCount
       | Attributes count: $attributesCount
       | =============================> Constant Pool ($constantPoolCount (-1)) <=============================
       | ${cpInfos.mkString("\n ")}
       | =============================> Interfaces ($interfacesCount) <=============================
       | ${interfaces.map(x => s"Constant pool reference: $x").mkString("\n ")}
       | =============================> Fields ($fieldCount) <=============================
       | ${fields.mkString("\n ")}
       | =============================> Methods ($methodsCount) <=============================
       | ${methods.mkString("\n ")}
       | =============================> Attributes ($attributesCount) <=============================
       | ${attributes.mkString("\n ")}
       |
     """.stripMargin
  }

  override def foreach[U](f: (Any) => U): Unit = {
    f(magicNumber)
    f(minorVersion)
    f(majorVersion)
    f(constantPoolCount)
    cpInfos.foreach(f)
    f(accessFlags)
    f(superClass)
    f(interfacesCount)
    interfaces.foreach(f)
    f(fieldCount)
    fields.foreach(f)
    f(methodsCount)
    methods.foreach(f)
    f(attributesCount)
    attributes.foreach(f)
  }
}

