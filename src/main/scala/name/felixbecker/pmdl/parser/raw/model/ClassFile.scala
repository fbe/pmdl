package name.felixbecker.pmdl.parser.raw.model

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
                      fieldCount: Short
                      /*
                       field_info     fields[fields_count];
                       u2             methods_count;
                       method_info    methods[methods_count];
                       u2             attributes_count;
                       attribute_info attributes[attributes_count];
                       */


                      )  {



  override def toString: String = {
    cpInfos.map(_.toString).mkString("\n")
  }
}

trait CPInfo