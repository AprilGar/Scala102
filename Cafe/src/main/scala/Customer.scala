

case class Customer(order: List[MenuItem], loyaltyCard: Boolean, numberOfStars: Int)

object Customer{

  def addStar(customer: Customer): Int = {
    if (customer.loyaltyCard){
      customer.numberOfStars + 1
    } else {
      0
    }
  }

  def addItemToOrder(customer: Customer, menuItem: MenuItem): Customer = {
    customer.copy(order = customer.order :+ menuItem)
  }

  def premiumItemsPrice(customer: Customer): BigDecimal = {
    val premiumItemsOrdered = {
      customer.order.filter { item => item.Premium }
    }
      premiumItemsOrdered.map(item => item.price).sum
  }

  def loyaltyDiscount(cafe: Cafe, customer: Customer): BigDecimal = {
    if (customer.order.exists { item => item.Premium } && customer.numberOfStars <= 8) {
      (customer.numberOfStars * ((Cafe.totalBill(cafe, customer) - premiumItemsPrice(customer)) * 0.025)) + premiumItemsPrice(customer)
    } else if (customer.numberOfStars <= 8) {
      customer.numberOfStars * Cafe.totalBill(cafe, customer) * 0.025
    } else {
      Cafe.totalBill(cafe, customer) * 0.8
    }
  }



}