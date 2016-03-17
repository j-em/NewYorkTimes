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

  implicit def ByLineCodec: CodecJson[ByLine] =
    casecodec2(ByLine.apply, ByLine.unapply)("organization", "original")

  implicit def MetaCodec: CodecJson[Meta] =
    casecodec3(Meta.apply, Meta.unapply)("hits", "time", "offset")

  implicit def ArticlesCodec: CodecJson[Articles] =
    casecodec2(Articles.apply, Articles.unapply)("docs", "meta")

  implicit def MultimediaCodec: CodecJson[Multimedia] =
    casecodec8(Multimedia.apply, Multimedia.unapply)("url", "format", "height", "width", "type", "subtype", "caption", "copyright")

  implicit def HeadLineCodec: CodecJson[HeadLine] =
    casecodec2(HeadLine.apply, HeadLine.unapply)("main", "kicker")

  implicit def KeywordsCodec: CodecJson[Keywords] =
    casecodec3(Keywords.apply, Keywords.unapply)("rank", "name", "value")

  implicit def ArticleCodec: CodecJson[Article] =
    casecodec18(Article.apply, Article.unapply)("web_url", "snippet", "lead_paragraph", "abstract", "print_page", "blog", "source", "headline", "keywords", "pub_date", "document_type", "news_desK", "section_name", "subsection_name", "byline", "type_of_material", "_id", "slideshows_credits")

  implicit def ResponseCodec: DecodeJson[Response] =
    casecodec3(Response.apply, Response.unapply)("response", "status", "copyright")
}

