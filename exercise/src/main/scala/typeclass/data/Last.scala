package typeclass.data

import scalaprops.Gen

import typeclass.Monoid

case class Last[A](value: Option[A])

object Last {
  implicit def gen[A: Gen]: Gen[Last[A]] = Gen[Option[A]].map(Last(_))

  implicit def Monoid[A]: Monoid[Last[A]] = new Monoid[Last[A]] {

    override def empty: Last[A] = Last(None)

    override def combine(x: Last[A], y: Last[A]): Last[A] = Last(y.value.orElse(x.value))
  }
}
