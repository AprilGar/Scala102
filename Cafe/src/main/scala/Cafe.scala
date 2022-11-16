
case class Cafe (name: String, menuItems: List[MenuItem], order: List[MenuItem])

object Cafe {
  def addMenuItem(cafe: Cafe, menuItem: MenuItem): Cafe = {
    cafe.copy(menuItems = cafe.menuItems :+ menuItem)
  }

  def totalBill(cafe: Cafe): BigDecimal = {
    cafe.order.map(item => item.price).sum
  }

  def addVatToBill(cafe: Cafe): BigDecimal = {
    val serviceCharge10 = totalBill(cafe)*0.1
    val serviceCharge20 = totalBill(cafe)*0.2
    val serviceCharge25 = totalBill(cafe)*0.25

   if (cafe.order.exists(item => item.Premium)) {
     if (serviceCharge25 <= 40.00) {
       totalBill(cafe) + serviceCharge25
     } else {
       totalBill(cafe) + 40.00
     }
   } else if (cafe.order.exists(item => item.Hot && !item.Drink)) {
      if (serviceCharge20 <= 20.00){
        totalBill(cafe) + serviceCharge20
      } else {
        totalBill(cafe) + 20.00
      }
    } else if (cafe.order.exists(item => !item.Hot && !item.Drink)) {
      totalBill(cafe) + serviceCharge10
    }
    else {
      totalBill(cafe)
    }
  }

}