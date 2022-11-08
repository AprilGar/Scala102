package caseClass

case class Kennel(name: String, dogs: List[Dog], cats: List[Cat], birds: List[Bird]) {

 def addDog (dog: Dog) : Kennel = {
  Kennel(name, dogs:+ dog, cats, birds)
 }

 def addCat(cat: Cat): Kennel = {
  Kennel(name, dogs, cats :+ cat, birds)
 }

 def addBird(bird: Bird): Kennel = {
  Kennel(name, dogs, cats, birds :+ bird)
 }

}
