package EDN

import java.util.{Date, GregorianCalendar, Calendar, TimeZone}
import java.text.SimpleDateFormat

/**
 * Namespace containing functions to read write RFC3339-like timestamps
*/
object Instant {

  val timestamp = """(\d\d\d\d)(?:-(\d\d)(?:-(\d\d)(?:[T](\d\d)(?::(\d\d)(?::(\d\d)(?:[.](\d+))?)?)?)?)?)?(?:[Z]|([-+])(\d\d):(\d\d))?""".r

  /**
   * Convert a string in RFC3339 format to a java.util.Date
   * @param src RFC3339 string
   * @return java.util.Date
   */
  def read(src: String) = {
    val timestamp(years, months, days, hours, minutes, seconds, nanoseconds, offsetSign, offsetHours, offsetMinutes) = src
    val cal = new GregorianCalendar(years.toInt, months.toInt - 1, days.toInt, hours.toInt, minutes.toInt, seconds.toInt)
    cal.set(Calendar.MILLISECOND, nanoseconds.toInt/1000000)
    cal.setTimeZone(TimeZone.getTimeZone(format("GMT%s%02d:%02d", offsetSign, offsetHours.toInt, offsetMinutes.toInt)))
    cal.getTime
  }

  /**
   * Convert a java.util.Date to a RFC3339 string
   * @param timestamp java.util.Date
   * @return String
   */
  def write(timestamp: Date) = {
    val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS-00:00")
    df.setTimeZone(TimeZone.getTimeZone("GMT"))
    "#inst \"" + df.format(timestamp) + "\""
  }
}
