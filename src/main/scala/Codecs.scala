package jem.nytimes
import Article._
import argonaut._, Argonaut._

object Codecs {
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
    casecodec18(Article.Article.apply, Article.Article.unapply)("web_url", "snippet", "lead_paragraph", "abstract", "print_page", "blog", "source", "headline", "keywords", "pub_date", "document_type", "news_desK", "section_name", "subsection_name", "byline", "type_of_material", "_id", "slideshows_credits")

  implicit def ResponseCode: DecodeJson[Response] =
    casecodec3(Response.apply, Response.unapply)("response", "status", "copyright")
}

