import org.scalatest.FlatSpec

class CafeSpec extends FlatSpec {

  val cola = MenuItem("cola", 0.50, false)
  val coffee = MenuItem("coffee", 1.00, true)
  val cheeseSandwich = MenuItem("cheese sandwich", 2.00, false)
  val steakSandwich = MenuItem("steak sandwich", 4.50, true)
  val menuItems: List[MenuItem] = List(cola, coffee, cheeseSandwich, steakSandwich)

  val order: List[MenuItem] = List(steakSandwich, cola)

  val sydneyCafe = Cafe("sydney cafe", menuItems, order)


  "Cafe" should "add menu item to the menu list" in {
    val tea = MenuItem("tea", 0.80, true)
    val updatedMenu = Cafe.addMenuItem(sydneyCafe, tea)
    assert(updatedMenu == Cafe("sydney cafe", List(cola, coffee, cheeseSandwich, steakSandwich, tea), order))
  }

  "Cafe" should "add price of all items in the order" in {
    assert (Cafe.totalBill(sydneyCafe) == 5.00)
  }

  "Cafe" should "add 20% vat onto bill" in {
    assert (Cafe.addVatToBill(sydneyCafe) == 6.00)
  }

}
