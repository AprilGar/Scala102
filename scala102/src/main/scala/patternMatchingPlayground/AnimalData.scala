package patternMatchingPlayground

object AnimalData extends App{

  val animal1 = Dog ("loki", 3)
  val animal2 = Cat ("sam", 15)
  val animal3 = Badger ("jeff", 2)

  def animalType(animal: Animal): Unit = {
    println( animal match {
      case animal: Dog => "Puppy!"
      case animal: Cat => "Kitty!"
      case _ => "Other"
    })
  }
  animalType(animal3)

  def calledSam(animal: Animal): Unit = {
    animal.name match{
      case "sam" | "Sam" => println(s"Sam is age ${animal.age}")
      case _ => println(s"${animal.name} is not called Sam!")
    }
  }
  calledSam(animal2)

  def youngOrOld (animal: Animal): Unit = {
    animal.age match {
      case x if  x > 10 => println(s"${animal.name} is ${animal.age}!")
      case x if x <= 10 => println(s"${animal.name} is young.")
    }
  }
  youngOrOld(animal2)

}
