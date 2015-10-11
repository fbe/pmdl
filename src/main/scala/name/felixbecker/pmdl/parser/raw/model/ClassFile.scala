package name.felixbecker.pmdl.parser.raw.model

import name.felixbecker.pmdl.parser.raw.MethodInfo

// Representation of a raw class file, defined in https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html

case class ClassFile(
                      magicNumber: Int,
                      minorVersion: Short,
                      majorVersion: Short,
                      constantPoolCount: Short,
                      cpInfos: List[CPInfo],
                      accessFlags: Short,
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
    cpInfos.map(_.toString).mkString("\n")
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

trait CPInfo