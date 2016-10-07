package object app {
  type Traversable[+A] = scala.collection.immutable.Traversable[A]
  val Traversable = scala.collection.immutable.Traversable

  type Iterable[+A] = scala.collection.immutable.Iterable[A]
  val Iterable = scala.collection.immutable.Iterable

  type Seq[+A] = scala.collection.immutable.Seq[A]
  val Seq = scala.collection.immutable.Seq

  type IndexedSeq[+A] = scala.collection.immutable.IndexedSeq[A]
  val IndexedSeq = scala.collection.immutable.IndexedSeq
}
