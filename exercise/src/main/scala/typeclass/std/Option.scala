package typeclass.std

import typeclass.{Functor, Monoid}

object option {

  implicit def optionMonoid[A](implicit evA: Monoid[A]): Monoid[Option[A]] = new Monoid[Option[A]] {

    override def empty: Option[A] = None

    def combine(x: Option[A], y: Option[A]): Option[A] = (x, y) match {
      case (Some(xx), Some(yy)) => Some(evA.combine(xx, yy))
      case _ => None
    }
  }

  implicit val functor: Functor[Option] = new Functor[Option] {
    override def map[A, B](fa: Option[A])(f: (A) => B): Option[B] = fa.map(f)
  }

}
