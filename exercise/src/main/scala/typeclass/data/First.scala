package typeclass.data

import scalaprops.Gen

import typeclass.Monoid

case class First[A](value: Option[A])

object First {
  implicit def gen[A: Gen]: Gen[First[A]] = Gen[Option[A]].map(First(_))

  implicit def monoid[A]: Monoid[First[A]] = new Monoid[First[A]] {

    override def empty: First[A] = First(None)

    override def combine(x: First[A], y: First[A]): First[A] = First(x.value.orElse(y.value))
  }
}