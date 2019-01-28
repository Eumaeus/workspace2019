
import scala.io.Source
import edu.holycross.shot.scm._
import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.seqcomp._


def loadLibrary(fp:String = "cex/hmt-2018g.cex"):CiteLibrary = {
	val library = CiteLibrary(Source.fromFile(fp).getLines.mkString("\n"),"#",",")
	library
}

println()
println()
println("Load a library with, e.g.:")
println()
println("""scala> val myLib = loadLibrary("cex/hmt-2018g.cex")""")

