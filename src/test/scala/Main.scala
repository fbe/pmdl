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

  val result = (Seq("find", "/home/becker/kaufhof/git/", "-iname" ,"*.class") #| Seq("xargs", "realpath")).lineStream.toList
  result.foreach(getClassFile)

//  getClassFile("/home/becker/kaufhof/git/gkh-explore/modules/smc/target/scala-2.11/classes/mam/soap/generated/XMLProtocol.class")


}