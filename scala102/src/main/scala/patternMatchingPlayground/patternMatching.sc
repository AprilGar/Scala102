val iceCreamFlavour: String = "carrot"

iceCreamFlavour match {
  case "cookie" => "cookie dough"
  case "chocolate" => "chocolate fudge brownie"
  case "caramel" => "caramel chew chew"
  case _ => "Enter a valid flavour"
}

val pizzaSize: Int = 8

pizzaSize match {
  case 7 => "personal"
  case 9 => "small"
  case 11 => "medium"
  case 14 => "large"
  case _ => "Enter a valid size"
}

val city: String = "London"

city match {
  case "Belfast" => s"$city".toUpperCase()
  case "London" => s"$city".toUpperCase()
  case "Edinburgh" => s"$city".toUpperCase()
  case "Cardiff" => s"$city".toUpperCase()
  case _ => s"$city isn't a capital city!"
}