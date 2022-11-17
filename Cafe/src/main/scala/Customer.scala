

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

  def loyaltyDiscount(customer: Customer): BigDecimal = {
    if (customer.numberOfStars <= 8) {
      1 - customer.numberOfStars * 0.025
    } else {
      1 - 0.2
    }
  }

}