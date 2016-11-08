package typeclass.std

import scalaprops.Scalaprops

import typeclass.FunctorLaws
import typeclass.std.option._

object OptionTest extends Scalaprops {

  val func = FunctorLaws[Option].all

}
