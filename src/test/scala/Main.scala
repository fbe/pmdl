import java.nio.ByteBuffer
import java.nio.file.{Paths, Files}

import name.felixbecker.pmdl.rawstructure.ClassFile

object Main extends App {

  def getClassFile(testClassFile: String): ClassFile = {
    val array = Files.readAllBytes(Paths.get(testClassFile))
    println(s"Loaded ${array.size} bytes from File $testClassFile")
    val bytes = ByteBuffer.wrap(array)
    val rawClassFile = ClassFile.fromByteBuffer(bytes)
    rawClassFile
  }



  import scala.sys.process._

  //val result = (Seq("find", "/home/becker/dgl/hybris-platform/", "-iname" ,"*.class") #| Seq("xargs", "realpath")).lineStream.toList
  //result.foreach(getClassFile)

  getClassFile("/home/becker/dgl/hybris-platform/bin/extensions/douglas/classes/de/douglas/services/deucs/jaxb/DebtorStatus.class")


}