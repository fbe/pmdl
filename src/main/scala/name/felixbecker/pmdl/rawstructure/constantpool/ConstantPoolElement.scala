package name.felixbecker.pmdl.rawstructure.constantpool

/**
 * Created by becker on 10/11/15.
 */
trait ConstantPoolElement {
  // override for double and long, the use 2 slots in the constant pool
  def requiredSlots: Short = 1
  def getConstantPoolTag: Byte
}
