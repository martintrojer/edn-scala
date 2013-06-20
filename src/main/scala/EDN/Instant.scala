package EDN

import java.util.{Date, GregorianCalendar, Calendar, TimeZone}
import java.text.SimpleDateFormat

object Instant {

  val timestamp = """(\d\d\d\d)(?:-(\d\d)(?:-(\d\d)(?:[T](\d\d)(?::(\d\d)(?::(\d\d)(?:[.](\d+))?)?)?)?)?)?(?:[Z]|([-+])(\d\d):(\d\d))?""".r

  def read(src: String) = {
    val timestamp(years, months, days, hours, minutes, seconds, nanoseconds, offsetSign, offsetHours, offsetMinutes) = src
    val cal = new GregorianCalendar(years.toInt, months.toInt - 1, days.toInt, hours.toInt, minutes.toInt, seconds.toInt)
    cal.set(Calendar.MILLISECOND, nanoseconds.toInt/1000000)
    cal.setTimeZone(TimeZone.getTimeZone(format("GMT%s%02d:%02d", offsetSign, offsetHours.toInt, offsetMinutes.toInt)))
    cal.getTime
  }

  def write(timestamp: Date) = {
    val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS-00:00")
    df.setTimeZone(TimeZone.getTimeZone("GMT"))
    "#inst \"" + df.format(timestamp) + "\""
  }
}
