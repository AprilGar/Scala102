package patternMatchingPlayground

object PizzaPriceData extends App{

  val pizza1: Pizza = Pizza(14, "stuffed")

  println(
    pizza1 match {
    case Pizza(7, "classic") => 5.99
    case Pizza(9, "classic") => 10.99
    case Pizza(9, "italian") => 10.99
    case Pizza(11, "classic") => 12.99
    case Pizza(11, "italian") => 12.99
    case Pizza(11, "stuffed") => 15.98
    case Pizza(14, "classic") => 14.99
    case Pizza(14, "italian") => 14.99
    case Pizza(14, "stuffed") => 17.98
    case _ => "Enter a valid pizza"
  })

}
