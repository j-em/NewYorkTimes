package jem.nytimes
import scalaj.http._
import argonaut._, Argonaut._
import Article._
import scalaz._
import Scalaz._
import effect._
import std._
import syntax.std._
import Codecs._
import org.joda.time._

object NyTimes {
  type Key = String
  type Query = String

  type ArticleIO = IO[Option[List[Article]]]
  type ArticleFetcher = Function5[String, String, LocalDate, LocalDate, Int, Option[List[Article]]]

  def defaultRequestArticles(key: String, query: String, startDate: LocalDate, endDate: LocalDate, page: Int = 0): Option[List[Article]] =
    Http("https://api.nytimes.com/svc/search/v2/articlesearch.json").params(
      ("q", query),
      ("begin_date", startDate.toString("yyyMMdd")),
      ("end_date", endDate.toString("yyyMMdd")),
      ("api-key", key),
      ("page", page.toString)).asString.body.decodeOption[Response].>>= (_.response).>>= (_.docs)

  def getArticles(query: String, startDate: LocalDate, endDate: LocalDate, page: Int = 0, f: ArticleFetcher = defaultRequestArticles: ArticleFetcher): Reader[String, ArticleIO] =
    Reader((key: String) => IO(f(key, query,  startDate, endDate, page)))
}
