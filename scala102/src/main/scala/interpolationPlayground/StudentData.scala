package interpolationPlayground

object StudentData extends App {

  val billy = Student("Billy Brown", 14.01, 9, 13.08)
  val readingGap = {billy.readingAge} - {billy.age}

  println(s"${billy.fullName} is ${billy.age} years in age, in school year ${billy.yearGroup} and has a reading age of ${billy.readingAge}.")
  println(f"The difference between ${billy.fullName}'s age and reading age is $readingGap%.2f in years and months.'")
  if (readingGap < 0) {
    println(s"${billy.fullName}'s reading age is below his actual age. Intervention is required.")
  } else {
    println(s"${billy.fullName}'s reading age is at a satisfactory level.")
  }

}
