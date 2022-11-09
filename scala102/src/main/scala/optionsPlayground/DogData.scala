package optionsPlayground

object DogData extends App {

  val dog1 = Dog ("Percy", true, Some("pink"))
  val dog2 = Dog ("Pokie", false, None)

  def hasSpots (dog: Dog): Unit = {
    dog.spotColour match {
      case Some(colour) => println(s"${dog.name} has ${colour} spots!")
      case None => println(s"${dog.name} has no spots!")
    }
  }
  hasSpots(dog1)

  def hasSpotsGet (dog: Dog): Unit = {
    println(dog.spotColour.getOrElse("No spots so no colour!"))
  }
  hasSpotsGet(dog2)
}
