import scala.math._

val pi = 3.14

def areaOfCircle(radius: Int): Double ={
  pi * Math.pow(radius, 2)
}
println(areaOfCircle(2))

def circumferenceOfCircle(radius:Int): Double = {
  2 * pi * radius
}
println(circumferenceOfCircle(2))

def circleFunctions (func: (Int) => Double, radii:List[Int]): List[Double] = {
  radii.map{radius => func(radius)}
}

circleFunctions(areaOfCircle, List(1, 2, 3, 4, 5))
circleFunctions(circumferenceOfCircle, List(1, 2, 3, 4, 5))