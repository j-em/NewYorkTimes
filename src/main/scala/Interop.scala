package jem.nytimes;
import NyTimes._
import scalaz._
import Scalaz._

object Interop {
  val getArticles = defaultRequestArticles _ map (_ getOrElse(null) )
}

