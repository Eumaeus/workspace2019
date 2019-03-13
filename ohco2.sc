import scala.io.Source
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.scm._


val demoCexFile:String = "cex/pope_iliad.cex"

def loadLibrary(fp:String = demoCexFile):CiteLibrary = {
	val library = CiteLibrary(Source.fromFile(fp).getLines.mkString("\n"),"#",",")
	library
}

/* Playing with URNs */

val oneTwo:CtsUrn = CtsUrn("urn:cts:fufolio:pope.iliad.fu2019:1.2")

val oneTwoOne:CtsUrn = CtsUrn("urn:cts:fufolio:pope.iliad.fu2019:1.2.1")
val oneTwoTwo:CtsUrn = CtsUrn("urn:cts:fufolio:pope.iliad.fu2019:1.2.2")

val rangeUrn:CtsUrn = CtsUrn("urn:cts:fufolio:pope.iliad.fu2019:1.2.1-1.2.5")

val utterlyDifferent:CtsUrn = CtsUrn("urn:cts:greekLit:tlg0016.tlg001.grc:8.22")

oneTwo.isRange == false
rangeUrn.isRange == true
oneTwo < oneTwoOne == false
oneTwo > oneTwoOne == true
oneTwoOne ~~ oneTwo == true
oneTwoOne ~~ oneTwoTwo == false
utterlyDifferent ~~ oneTwo == false
utterlyDifferent >< oneTwo == true

s"oneTwo passage component: ${oneTwo.passageComponent}"
s"rangeUrn passage component: ${rangeUrn.passageComponent}"

/* Making a Corpus */
lazy val library:CiteLibrary = loadLibrary()

lazy val textRepo:Option[TextRepository] = library.textRepository