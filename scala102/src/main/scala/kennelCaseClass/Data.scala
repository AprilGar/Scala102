package kennelCaseClass

object Data extends App {

  val loki = Dog("loki", "collie X", 3)
  val maple = Dog("maple", "cockerpoo", 4)
  val moose = Dog("moose", "cockerpoo", 4)
  val okey = Dog("okey", "samoyed", 10)
  val dogs: List[Dog] = List(loki, maple, moose, okey)

  val ginger = Cat("ginger", "bengal", 1)
  val oakley = Cat("oakley", "tabby", 7)
  val cats: List[Cat] = List(ginger, oakley)

  val wellie = Bird("wellie", "cockatoo", 10)
  val rockin = Bird("rockin", "robin", 5)
  val birds: List[Bird] = List(wellie, rockin)

  val sydneyKennel = Kennel("Sydney Kennel", dogs, cats, birds)
  val updatedSydneyKennel = sydneyKennel.addDog(Dog ("duffle", "samoyed", 10))
  val reNamedSydneyKennel = updatedSydneyKennel.copy(name = "Loki & friends")

  println(sydneyKennel)
  println(updatedSydneyKennel)
  println(reNamedSydneyKennel)




}
