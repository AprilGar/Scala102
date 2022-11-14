import scala.util.Random

val random = new Random

val spongebob = "Gary, I’m absorbing his blows like I’m made of some sort of spongy material"
val patrick = "Well, it may be stupid, but it’s also dumb."

def matchingQuote (quote: Option[String]): String = {
  quote match {
    case Some("spongebob") => spongebob
    case Some("patrick") => patrick
    case None => "Dumb people are always blissfully unaware of how dumb they really are…"
    case _ => "Not sure on that character..."
  }
}
println(matchingQuote(Some("patrick")))

val quotes: List[String] = List("The unexamined life is not worth living",
  "Whereof one cannot speak, thereof one must be silent",
  "Entities should not be multiplied unnecessarily",
  "He who thinks great thoughts, often makes great errors",
  "We live in the best of all possible worlds",
  "God is dead! He remains dead! And we have killed him")

val randomQuote = quotes(random.nextInt(quotes.length))

def optionalQuote (quote: Option[String]): String = {
  quote match {
    case Some(quote) => s"$quote"
    case None => randomQuote
  }
}
//println(optionalQuote(Some("I am a string")))
println(optionalQuote(None))

def quoteFunctions (func: (Option[String]) => String, quote: Option[String]): String = {
  func(quote)
}
quoteFunctions(optionalQuote, Some("I'm a quote"))
quoteFunctions(optionalQuote, None)
quoteFunctions(matchingQuote, Some("patrick"))
quoteFunctions(matchingQuote, None)