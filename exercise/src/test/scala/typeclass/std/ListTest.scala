package typeclass.std

import scalaprops.Scalaprops

import typeclass.FunctorLaws
import typeclass.std.list._

object ListTest extends Scalaprops {

  val func = FunctorLaws[List].all

}
