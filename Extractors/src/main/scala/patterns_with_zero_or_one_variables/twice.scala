package patterns_with_zero_or_one_variables

object EMail {
  def apply(user: String, domain: String) = user + "@" + domain
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) Some(half) else None
  }
}

object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}

object Main extends App {
  def userTwiceUpper(s: String) = s match {
    case EMail(Twice(x @ UpperCase()), domain) =>
      "match: " + x + " in domain " + domain
    case _ => "no match"
  }
  println(userTwiceUpper("DIDI@hotmail.com"))
  println(userTwiceUpper("DIDO@hotmail.com"))
  println(userTwiceUpper("didi@hotmail.com"))
}
