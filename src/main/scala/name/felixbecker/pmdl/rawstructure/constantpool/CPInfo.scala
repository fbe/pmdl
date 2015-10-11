package name.felixbecker.pmdl.rawstructure.constantpool


trait CPInfo {
  def cpIndex: Short

  def toStringInternal: String

  override def toString = {
    val formattedCpIndex = "%05d".format(cpIndex)
    val simpleClassName = getClass.getSimpleName.substring(2)
    s"[$formattedCpIndex] $simpleClassName - $toStringInternal"
  }
}


object CPInfo {

  val ClassTag = CPClassTag.getConstantPoolTag
  val Fieldref = CPFieldRef.getConstantPoolTag
  val Methodref = CPMethodRef.getConstantPoolTag
  val InterfaceMethodRef = CPInterfaceMethodRef.getConstantPoolTag
  val String = CPStringInfo.getConstantPoolTag
  val Integer = CPInteger.getConstantPoolTag
  val Float = CPFloat.getConstantPoolTag
  val Long = CPLong.getConstantPoolTag
  val Double = CPDouble.getConstantPoolTag
  val NameAndType = CPNameAndType.getConstantPoolTag
  val UTF8 = CPUTF8.getConstantPoolTag
  val MethodHandle = 15
  val MethodType = 16
  val InvokeDynamic = 18

  type ConstantPool = List[CPInfo]
}


