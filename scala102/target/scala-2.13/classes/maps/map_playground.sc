//1. Write a function using map which :-
//      Takes a String “macbooks”
//       Maps on each char to make them uppercase, and returns “MACBOOKS ARE THE BEST”

def toUpper (x: String): String = {
    s"${x.toUpperCase()} ARE THE BEST"
}
toUpper("macbooks")

val mapToUpper = "macbooks are the best".map(char => char.toUpper)


//2. Write a function which :-
//      Turns a list of strings to ints, e.g. List(“1”, “2”, “3”) -> List(1,2,3)
val stringToInt = List("1", "2", "3").map(x => x.toInt)

//      Multiplies each int by 2
val multiplyBy2 = List(1,2,3,4,5).map(x => x*2)

//      Finds the sum of the List
val list1 = List(1,2,3)
val sumOfList1 = list1.sum

// 3. Write a function that accepts an optional Int
//      multiplies the integer by 12,
//      if nothing is supplied return 12

def optionalMultipy (number: Option[Int]): Option[Int] = {
    number match {
        case Some(number) => Some(number*12)
        case None => None
    }
}
optionalMultipy(None)
optionalMultipy(Some(3))

//The following value is created to model recent exam results.
//Where a None means that the student did not attend.

val scores = Seq(None, Some("A"), Some("B"), Some("C"), None, Some("F"))

//What keyword could be used to only produce a list of results of those students that attended?
// Seq? List? map?

//Using map turn the scores of the students that didn’t attend into an F.
//E.g. should result in List(F, A, B, C, F, F)

val mapOfScores = scores.map(x => if (x.isEmpty) Right[String, String]("F") else x)