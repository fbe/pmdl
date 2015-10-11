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
