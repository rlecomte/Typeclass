package typeclass.data

import scalaprops.Scalaprops

import typeclass.MonoidLaws

object FirstTest extends Scalaprops {

  val semigroup = MonoidLaws[First[Int]].all
}
