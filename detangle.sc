import scala.io.Source
import edu.holycross.shot.cite._

val filepath:String = "texts/tangled.txt"
val myLines:Vector[String] = Source.fromFile(filepath).getLines.toVector.filter( _.size > 0 )

// Grab line numbers

// Filter out chapter headings

// find where each chapter begins and ends!

