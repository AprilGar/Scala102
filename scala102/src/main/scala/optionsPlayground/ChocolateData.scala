package optionsPlayground

object ChocolateData extends App{

  val caramel = ChocolateBar(Some("smooth caramel"))
  val milkyBar = ChocolateBar(None)
  val aero = ChocolateBar(Some("minty bubbles"))

  def isThereFilling (chocolateBar: ChocolateBar): Unit = {
    println(chocolateBar.filling match {
      case Some(filling) => s"This has a filling of ${filling}!"
      case None => "No filling here!"
    })
  }

  isThereFilling(aero)

}
