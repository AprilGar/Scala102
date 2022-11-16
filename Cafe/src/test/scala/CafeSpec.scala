import org.scalatest.FlatSpec

class CafeSpec extends FlatSpec {

  //Menu Items data
  val cola: MenuItem = MenuItem("cola", 0.50, Hot = false, Drink = true, Premium = false)
  val coffee = MenuItem("coffee", 1.00, true, true, false)
  val cheeseSandwich = MenuItem("cheese sandwich", 2.00, false, false, false)
  val steakSandwich = MenuItem("steak sandwich", 4.50, true, false, false)
  val expensiveItem = MenuItem("I'm expensive", 120.00, true, false, false)
  val lobsterRavioli = MenuItem("lobster ravioli", 25.00, true, false, true)
  val menuItems: List[MenuItem] = List(cola, coffee, cheeseSandwich, steakSandwich)

  "Cafe" should "add menu item to the menu list" in {
    val tea = MenuItem("tea", 0.80, true, true, false)
    val order: List[MenuItem] = List(steakSandwich, cola)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    val updatedMenu = Cafe.addMenuItem(sydneyCafe, tea)
    assert(updatedMenu == Cafe("sydney cafe", List(cola, coffee, cheeseSandwich, steakSandwich, tea), order))
  }

  "Cafe" should "add price of all items in the order" in {
    val order: List[MenuItem] = List(steakSandwich, cola)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    assert (Cafe.totalBill(sydneyCafe, customer) == 5.00)
  }

  "Cafe" should "NOT put vat onto bill if only includes drinks" in {
    val order: List[MenuItem] = List(coffee, cola)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    assert(Cafe.addVatToBill(sydneyCafe,customer) == 1.50)
  }

  "Cafe" should "add 10% vat onto bill if includes cold food" in {
    val order: List[MenuItem] = List(cheeseSandwich, cola)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    assert(Cafe.addVatToBill(sydneyCafe, customer) == 2.75)
  }

  "Cafe" should "add 20% vat onto bill if includes hot food" in {
    val order: List[MenuItem] = List(steakSandwich, cola)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    assert (Cafe.addVatToBill(sydneyCafe, customer) == 6.00)
  }

  "Cafe" should "add £20 vat onto bill if 20% of bill exceeds £20" in {
    val order: List[MenuItem] = List(expensiveItem, coffee)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    assert(Cafe.addVatToBill(sydneyCafe, customer) == 141.00)
  }

  "Cafe" should "add 25% vat onto bill if it includes a premium item" in {
    val order: List[MenuItem] = List(lobsterRavioli, steakSandwich, cola)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    assert(Cafe.addVatToBill(sydneyCafe, customer) == 37.5)
  }

  "Cafe" should "add £40 vat onto bill if it includes a premium item and 25% > £40" in {
    val order: List[MenuItem] = List(lobsterRavioli, expensiveItem, expensiveItem)
    val customer = Customer(order, false, 0)
    val sydneyCafe = Cafe("sydney cafe", menuItems, order)
    assert(Cafe.addVatToBill(sydneyCafe, customer) == 305)
  }

  "Customer" should "increase number of stars by 1" in {
    val order: List[MenuItem] = List(steakSandwich, cola)
    val customer = Customer(order, true, 0)
    assert(Customer.addStar(customer) == 1)
  }

  "Customer" should "return 0 if customer does not have a loyalty card" in {
    val order: List[MenuItem] = List(steakSandwich, cola)
    val customer = Customer(order, false, 0)
    assert(Customer.addStar(customer) == 0)
  }

  "Customer" should "add menu item to the order" in {
    val order: List[MenuItem] = List(steakSandwich, cola)
    val customer = Customer(order, true, 3)
    val updatedOrder = Customer.addItemToOrder(customer, coffee)
    assert(updatedOrder == Customer(List(steakSandwich, cola, coffee), true, 3))
  }

}
