package typeclass

trait Monoid[A] extends Semigroup[A] {
  def empty: A

  def isEmpty(a: A): Boolean = a == empty
  def ifEmpty[B](a: A)(t: => B)(f: => B): B = if (isEmpty(a)) t else f
}

object Monoid {
  def apply[A](implicit ev: Monoid[A]): Monoid[A] = ev
}

case class MonoidLaws[A](implicit ev: Monoid[A]) {
  import typeclass.syntax.semigroup._

  import scalaprops.Properties.properties
  import scalaprops.Property.forAll
  import scalaprops.{Gen, Properties, Property}
  import scalaz.std.string._

  def leftIdentity(implicit genA: Gen[A]): Property = forAll((x: A) => ev.empty.combine(x) == x)

  def rightIdentity(implicit genA: Gen[A]): Property = forAll((x: A) => x.combine(ev.empty) == x)

  def laws(implicit genA: Gen[A]): Properties[String] =
    properties("Monoid")(
      ("leftIdentity" , leftIdentity),
      ("rightIdentity", rightIdentity)
    )

  def all(implicit genA: Gen[A]): Properties[String] =
    Properties.fromProps("Monoid-all", SemigroupLaws[A].all, laws)
}