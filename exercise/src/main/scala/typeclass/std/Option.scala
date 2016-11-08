package typeclass.std

import typeclass.{Monoid, Semigroup}

object option {

  implicit def optionMonoid[A](implicit evA: Monoid[A]): Monoid[Option[A]] = new Monoid[Option[A]] {

    override def empty: Option[A] = None

    def combine(x: Option[A], y: Option[A]): Option[A] = (x, y) match {
      case (Some(xx), Some(yy)) => Some(evA.combine(xx, yy))
      case _ => None
    }
  }

}
