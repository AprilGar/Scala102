import java.util.Date
import java.text
import java.text.SimpleDateFormat
import java.time.LocalTime

//val date = new Date()
//
//date.toString

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import java.time.LocalDate
import java.time.format.DateTimeFormatter

//val date = LocalDate.now()
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
val time: String = formatter.format(LocalTime.now())
