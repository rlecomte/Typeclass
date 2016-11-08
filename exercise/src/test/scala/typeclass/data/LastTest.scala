package typeclass.data

import scalaprops.Scalaprops

import typeclass.MonoidLaws

object LastTest extends Scalaprops {

  val semigroup = MonoidLaws[Last[Int]].all
}
