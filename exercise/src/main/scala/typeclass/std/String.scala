package typeclass.std

import typeclass.Monoid

object string {

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {

    override def empty: String = ""

    override def combine(x: String, y: String): String = x ++ y
  }
}