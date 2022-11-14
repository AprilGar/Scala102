val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None

def doubledOrNone(number: Option[Int]): Unit = {
  number match {
    case Some(number) => println(number*2)
    case None => println("None")
  }
}

doubledOrNone(number)