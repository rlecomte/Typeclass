package typeclass.data

import scalaprops.Scalaprops

import typeclass.SemigroupLaws

object MultTest extends Scalaprops {

  val monoid = SemigroupLaws[Mult].all

}
