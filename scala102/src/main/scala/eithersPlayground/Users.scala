package eithersPlayground

object Users extends App {

  case class User (username: String, password: String)

  val april = User("april", "password")
  val robyn = User("robyn", "password")

  def userExists(user: User): Boolean = {
    (user) match {
      case User("april", "password") => true
      case _ => false
    }
  }

  def login (func: (User) => Boolean, user: User): Either[Exception, Boolean] = {
    func(user) match {
      case true => Right(true)
      case false => Left(throw new Exception("UserNotFoundError"))
    }
  }
  println(login(userExists, robyn))
}
