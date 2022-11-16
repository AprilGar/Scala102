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




}