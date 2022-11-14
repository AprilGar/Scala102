package enumerationPractical

case class Animal(typeOfAnimal: TypeOfAnimal.Value, canFly: CanFly.Value, diet: Diet.Value, habitat: Habitat.Value)

object TypeOfAnimal extends Enumeration {
  val reptile, bird, mammal = Value
}

object CanFly extends Enumeration {
  val yes, no, KindOf = Value
}

object Diet extends Enumeration {
  val herbivore, omnivore, carnivore = Value
}

object Habitat extends Enumeration {
  val forest, desert, polar, ocean, freshwater = Value
}