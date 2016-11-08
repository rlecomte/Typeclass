package typeclass.data

import scalaprops.Scalaprops

import typeclass.MonoidLaws

object FirstTest extends Scalaprops {

  val monoid = MonoidLaws[First[Int]].all
}
