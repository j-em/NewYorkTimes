import jem.nytimes._
import NyTimes._
import Article.{Article, HeadLine, Keywords, ByLine}
import java.time._
import format._
import org.scalatest._
import org.scalatest.Matchers._

class NyTimesSpec extends FlatSpec
{
  val defaultKey = "mykey"
  val defaultQuery = "animals"

  val testFetcher: ArticleFetcher = (key, query, start_date, end_date, page) => Some(mocked_articles)
  val articles = getArticles(defaultQuery, LocalDate.of(2012, 1, 1), LocalDate.of(2012, 1, 1), f = testFetcher).run(defaultKey).unsafePerformIO()

  val mocked_articles = List(
    Article(web_url= "weburl.com",
      snippet= "mysnipper",
      lead_paragraph= Some("leadparagraph"),
      _abstract= Some("abstract"),
      print_page= Some("page"),
      blog= List("po"),
      source= "source",
      headline= Option(HeadLine("hl", Some("p"))),
      keywords= List(Keywords(Some("Advanced"), Some("Senior"), Some("3"))),
      pub_date= "pub_date",
      document_type= "doc type",
      news_desK= Some("news_Desk"),
      section_name= Some("mysection"),
      subsection_name= Some("subsex"),
      byline= Some(ByLine(Some("Myorg"), Some("original"))),
      type_of_material= "type",
      _id= "1222",
      slideshows_credits= Some("cred")))

  "getArticles" should "parse articles" in {
    articles shouldBe defined
  }

}
