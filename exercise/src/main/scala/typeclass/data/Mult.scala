package typeclass.data

import scalaprops.Gen

import typeclass.Semigroup

case class Mult(value: Int)

object Mult {
  implicit val gen: Gen[Mult] = Gen[Int].map(Mult(_))

  implicit val semigroup: Semigroup[Mult] = new Semigroup[Mult] {
    def combine(x: Mult, y: Mult): Mult = Mult(x.value * y.value)
  }
}