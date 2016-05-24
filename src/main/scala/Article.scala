package jem.nytimes;
import argonaut._, Argonaut._

object Article {
  case class ByLine(organization: Option[String], original: Option[String])

  case class Meta(hits: Int, time: Int, offset: Int)

  case class Multimedia(url: String, format: String, height: Int, width: Int, _type: String, subtype: String, caption: String, copyright: String)

  case class Keywords(rank: Option[String], name: Option[String], value: Option[String])

  case class HeadLine(main: String, kicker: Option[String])

  case class Articles(docs: Option[List[Article]], meta: Meta)
  case class Response(response: Option[Articles], status: String, copyright: String)

  case class Article(
    web_url: String,
    snippet: String,
    lead_paragraph: Option[String],
    _abstract: Option[String],
    print_page: Option[String],
    blog: List[String],
    source: String,
    headline: Option[HeadLine],
    keywords: List[Keywords],
    pub_date: String,
    document_type: String,
    news_desK: Option[String],
    section_name: Option[String],
    subsection_name: Option[String],
    byline: Option[ByLine],
    type_of_material: String,
    _id: String,
    slideshows_credits: Option[String]
  )
}

