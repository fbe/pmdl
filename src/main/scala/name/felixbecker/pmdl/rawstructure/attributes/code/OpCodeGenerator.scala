package name.felixbecker.pmdl.rawstructure.attributes.code

import java.net.URL

import org.htmlcleaner.{TagNode, HtmlCleaner}
import scala.collection.JavaConversions._

/**
 * Created by becker on 10/14/15.
 */
private[code] object OpCodeGenerator extends App {

    val cleaner = new HtmlCleaner
    val props = cleaner.getProperties
    val rootNode = cleaner.clean(new URL("https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html"))
    for(elem <- rootNode.getElementListByAttValue("class", "section-execution", true, false)){
      val literallayout = elem.findElementByAttValue("title", "Forms", true, false)
      val ems = literallayout.evaluateXPath("//em").collect{case t: TagNode => t}
      if(ems.size > 1)
      println(s"${ems.head.getText}: ${ems.tail.map(_.getText).mkString(",")}")
      else
      println(s"${ems.head.getText}")
      //elem.evaluateXPath("//em").foreach(println)
      //literallayout
    }
    /*val elements = rootNode.getElementsByName("a", true)
    for (elem <- elements) {
      val classType = elem.getAttributeByName("class")
      if (classType != null && classType.equalsIgnoreCase("articleTitle")) {
        // stories might be "dirty" with text like "'", clean it up
        val text = StringEscapeUtils.unescapeHtml4(elem.getText.toString)
        stories += text
      }
    }
    return stories.filter(storyContainsDesiredPhrase(_)).toList
    */
}
