package typeclass.std

import typeclass.{Functor, Monoid}

object list {

  implicit def listMonoid[A]: Monoid[List[A]] = new Monoid[List[A]] {

    override def empty: List[A] = Nil

    override def combine(x: List[A], y: List[A]): List[A] = x ++ y
  }

  implicit val functor: Functor[List] = new Functor[List] {
    override def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

}
