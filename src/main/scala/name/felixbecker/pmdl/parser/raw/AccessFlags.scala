package name.felixbecker.pmdl.parser.raw

case class AccessFlag(name: String, byteValue: Short)

object AccessFlags {

  type AccessFlagMap = Map[Int, AccessFlag]

  val ClassAccessFlags: AccessFlagMap = Map(
    0x0001 -> AccessFlag("ACC_PUBLIC", 0x0001),
    0x0010 -> AccessFlag("ACC_FINAL", 0x0010),
    0x0020 -> AccessFlag("ACC_SUPER", 0x0020),
    0x0200 -> AccessFlag("ACC_INTERFACE", 0x0200),
    0x0400 -> AccessFlag("ACC_ABSTRACT", 0x0400),
    0x1000 -> AccessFlag("ACC_SYNTHETIC", 0x1000),
    0x2000 -> AccessFlag("ACC_ANNOTATION", 0x2000),
    0x4000 -> AccessFlag("ACC_ENUM", 0x4000)
  )

  val FieldAccessFlags: AccessFlagMap = Map(
    0x0001 -> AccessFlag("ACC_PUBLIC", 0x0001),
    0x0002 -> AccessFlag("ACC_PRIVATE", 0x0002),
    0x0004 -> AccessFlag("ACC_PROTECTED", 0x0004),
    0x0008 -> AccessFlag("ACC_STATIC", 0x0008),
    0x0010 -> AccessFlag("ACC_FINAL", 0x0010),
    0x0040 -> AccessFlag("ACC_VOLATILE", 0x0040),
    0x0080 -> AccessFlag("ACC_TRANSIENT", 0x0080),
    0x1000 -> AccessFlag("ACC_SYNTHETIC", 0x1000),
    0x4000 -> AccessFlag("ACC_ENUM", 0x4000)
  )

  val MethodAccessFlags: AccessFlagMap = Map(
    0x0001 -> AccessFlag("ACC_PUBLIC", 0x0001),
    0x0002 -> AccessFlag("ACC_PRIVATE", 0x0002),
    0x0004 -> AccessFlag("ACC_PROTECTED", 0x0004),
    0x0008 -> AccessFlag("ACC_STATIC", 0x0008),
    0x0010 -> AccessFlag("ACC_FINAL", 0x0010),
    0x0020 -> AccessFlag("ACC_SYNCHRONIZED", 0x0020),
    0x0040 -> AccessFlag("ACC_BRIDGE", 0x0040),
    0x0080 -> AccessFlag("ACC_VARARGS", 0x0080),
    0x0100 -> AccessFlag("ACC_NATIVE", 0x0100),
    0x0400 -> AccessFlag("ACC_ABSTRACT", 0x0400),
    0x0800 -> AccessFlag("ACC_STRICT", 0x0800),
    0x1000 -> AccessFlag("ACC_SYNTHETIC", 0x1000)
  )

  val NestedClassAccessFlags: AccessFlagMap = Map(
    0x0001 -> AccessFlag("ACC_PUBLIC", 0x0001),
    0x0002 -> AccessFlag("ACC_PRIVATE", 0x0002),
    0x0004 -> AccessFlag("ACC_PROTECTED", 0x0004),
    0x0008 -> AccessFlag("ACC_STATIC", 0x0008),
    0x0010 -> AccessFlag("ACC_FINAL", 0x0010),
    0x0200 -> AccessFlag("ACC_INTERFACE", 0x0200),
    0x0400 -> AccessFlag("ACC_ABSTRACT", 0x0400),
    0x1000 -> AccessFlag("ACC_SYNTHETIC", 0x1000),
    0x2000 -> AccessFlag("ACC_ANNOTATION", 0x2000),
    0x4000 -> AccessFlag("ACC_ENUM", 0x4000)
  )

  // Maps don't like Map[Short, AccessFlag], type inference doesn't work here as expected - key is an integer :(
  def shortToAccessFlags(accessFlagsBytesAsShort: Short, accessFlagMap: AccessFlagMap): List[AccessFlag] = {
    accessFlagMap.collect { case (bitMask, accessFlag) if (accessFlagsBytesAsShort & bitMask) > 0 => accessFlag }.toList
  }

}

