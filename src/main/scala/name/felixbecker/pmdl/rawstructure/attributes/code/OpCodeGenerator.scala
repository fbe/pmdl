package name.felixbecker.pmdl.rawstructure.attributes.code

import java.net.URL

import org.htmlcleaner.{TagNode, HtmlCleaner}
import org.jsoup.Jsoup
import scala.collection.JavaConversions._

/**
 * Created by becker on 10/14/15.
 */
private[code] object OpCodeGenerator extends App {

  val document = Jsoup.connect("https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html").get()
  // class section-execution
  val sectionExecutions = document.getElementsByClass("section-execution")
  sectionExecutions.map { element =>
    println(element)
    System.exit(0);
    println(element.select("h3 em").size())
    println("end davon")
  }
}
