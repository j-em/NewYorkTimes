package jem.nytimes;
import java.time.LocalDate
import NyTimes._
import scalaz._
import Scalaz._

object Interop {
  case class Date(year: Int, month: Int, day: Int) {
    def toLocalDate(): LocalDate = LocalDate.of(this.year, this.month, this.day)
  }

  def getArticles(key: String, query: String, startDate: Date, endDate: Date, page: Int = 0) =
    defaultRequestArticles(key, query, startDate.toLocalDate(), endDate.toLocalDate(), page).getOrElse(null)
}
