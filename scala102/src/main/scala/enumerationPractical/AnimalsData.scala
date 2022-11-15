package enumerationPractical

  object AnimalsData extends App {

    val crocodile = Animal(TypeOfAnimal.reptile, CanFly.no, Diet.carnivore, Habitat.freshwater)
    val parrot = Animal(TypeOfAnimal.bird, CanFly.yes, Diet.herbivore, Habitat.forest)
    val rhino = Animal(TypeOfAnimal.mammal, CanFly.no, Diet.omnivore, Habitat.desert)

    def animalInfo(animal: Animal): Unit = {
      animal.typeOfAnimal match {
        case TypeOfAnimal.reptile => println("I'm a reptile")
        case TypeOfAnimal.bird => println("I'm a bird")
        case TypeOfAnimal.mammal => println("I'm a mammal")
      }
    }

    animalInfo(rhino)

  }