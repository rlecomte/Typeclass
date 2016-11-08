package typeclass.data

import scalaprops.Scalaprops

import typeclass.MonoidLaws

object LastTest extends Scalaprops {

  val monoid = MonoidLaws[Last[Int]].all
}
