case class Customer(order: List[MenuItem], loyaltyCard: Boolean, numberOfStars: Int)

object Customer{

  def addStar(customer: Customer): Int = {
    customer.numberOfStars + 1
  }



}