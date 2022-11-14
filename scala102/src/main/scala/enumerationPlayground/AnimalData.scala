package enumerationPlayground

//object AnimalData extends Enumeration {
//
//  val Pig, Hamster, Fox, Hippo, Seal = Value
//
//}

sealed trait AnimalData

case object Pig extends AnimalData
case object Hamster extends AnimalData
case object Fox extends AnimalData
case object Hippo extends AnimalData
case object Seal extends AnimalData