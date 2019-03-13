
import scala.io.Source
import java.io._
import scala.collection.mutable.LinkedHashMap
import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.citeobj._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.seqcomp._
import edu.furman.classics.citealign._


val urnBase:String = "urn:cts:fufolio:pope.iliad.fu2019:"


val scsLib:String = "/cite/scala/scs-akka/cex/library.cex"

def loadLibrary(fp:String = "/Users/cblackwell/Desktop/vm_Spring_2019/workspace2019/cex/hmt-2018g.cex"):CiteLibrary = {
	val library = CiteLibrary(Source.fromFile(fp).getLines.mkString("\n"),"#",",")
	library
}

def loadFile(fp:String = "../iliad_alignment/iliad_pope.txt"):Vector[String] = {
	Source.fromFile(fp).getLines.toVector
}


def saveString(s:String, filePath:String = "texts/", fileName:String = "temp.txt"):Unit = {
	val pw = new PrintWriter(new File(filePath + fileName))
	for (line <- s.lines){
		pw.append(line)
		pw.append("\n")
	}
	pw.close
}

// Convert an Int to a Roman Numeral
def toRoman(value: Int): String = {
"M" * (value / 1000) +
  ("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM").productElement(value % 1000 / 100) +
  ("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC").productElement(value % 100 / 10) +
  ("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX").productElement(value % 10)
}

// Convert a String that is a Roman Numeral to an Int
def fromRoman(s: String) : Int = {
	try {
		val numerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

		s.toUpperCase.map(numerals).foldLeft((0,0)) {
		  case ((sum, last), curr) =>  (sum + curr + (if (last < curr) -2*last else 0), curr) }._1
	} catch {
		case e:Exception => throw new Exception(s""" "${s}" is not a valid Roman Numeral.""")
	}
}

lazy val lib = loadLibrary()
lazy val tr = lib.textRepository.get
lazy val cr = lib.collectionRepository.get
lazy val rs = lib.relationSet.get