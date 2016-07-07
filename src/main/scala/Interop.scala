package jem.nytimes;
import NyTimes._
import collection.mutable._
import scala.collection.JavaConversions._
import scalaz._
import Scalaz._
import org.joda.time.LocalDate
import Article._

object Interop {
  def getArticles(key: String, query: String, startDate: LocalDate, endDate: LocalDate, page: scala.Int): java.util.List[Article] =
    defaultRequestArticles(key, query, startDate, endDate, page).getOrElse(null)
}
