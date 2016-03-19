package jem.nytimes;
import java.time._
import NyTimes.{getArticles => mGetArticles}

object Interop { 
  def getArticles(key: String, startDate: LocalDate, endDate: LocalDate, query: String, page: Int=0) = 
    mGetArticles(query: String, startDate: LocalDate, endDate: LocalDate, page: Int).run(key).unsafePerformIO().getOrElse(null)
} 

