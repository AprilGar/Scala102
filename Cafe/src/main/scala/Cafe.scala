
case class Cafe (name: String, menuItems: List[MenuItem], order: List[MenuItem])

object Cafe {
  def addMenuItem(cafe: Cafe, menuItem: MenuItem): Cafe = {
    cafe.copy(menuItems = cafe.menuItems :+ menuItem)
  }

  def totalBill(cafe: Cafe, customer: Customer): BigDecimal = {
    if (customer.loyaltyCard && customer.numberOfStars >= 3 && customer.order.exists { item => item.Premium }) {
      val totalOfPremiumItems = Customer.premiumItemsPrice(customer)
      val loyaltydiscount = Customer.loyaltyDiscount(customer)
      ((cafe.order.map(item => item.price).sum - totalOfPremiumItems) * loyaltydiscount) + totalOfPremiumItems
    } else if (customer.loyaltyCard && customer.numberOfStars >= 3) {
      val loyaltydiscount = Customer.loyaltyDiscount(customer)
      cafe.order.map(item => item.price).sum * loyaltydiscount
    } else {
      cafe.order.map(item => item.price).sum
    }
  }

  def addServiceToBill(cafe: Cafe, customer: Customer): BigDecimal = {
    val serviceCharge10 = totalBill(cafe, customer)*0.1
    val serviceCharge20 = totalBill(cafe, customer)*0.2
    val serviceCharge25 = totalBill(cafe, customer)*0.25

   if (cafe.order.exists(item => item.Premium)) {
     if (serviceCharge25 <= 40.00) {
       totalBill(cafe, customer) + serviceCharge25
     } else {
       totalBill(cafe, customer) + 40.00
     }
   } else if (cafe.order.exists(item => item.Hot && !item.Drink)) {
      if (serviceCharge20 <= 20.00){
        totalBill(cafe, customer) + serviceCharge20
      } else {
        totalBill(cafe, customer) + 20.00
      }
    } else if (cafe.order.exists(item => !item.Hot && !item.Drink)) {
      totalBill(cafe, customer) + serviceCharge10
    }
    else {
      totalBill(cafe, customer)
    }
  }

}