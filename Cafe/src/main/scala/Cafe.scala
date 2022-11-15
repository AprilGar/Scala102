
case class Cafe (name: String, menuItems: List[MenuItem], order: List[MenuItem])

object Cafe {
  def addMenuItem(cafe: Cafe, menuItem: MenuItem): Cafe = {
    cafe.copy(menuItems = cafe.menuItems :+ menuItem)
  }

  def totalBill(cafe: Cafe): BigDecimal = {
    (cafe.order.map(item => item.price).sum)
  }

  def addVatToBill(cafe: Cafe): BigDecimal = {
    totalBill(cafe)*1.2
  }
}