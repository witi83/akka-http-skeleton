package app

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import org.scalatest.{Matchers, WordSpec}

class AppSpec extends WordSpec with Matchers with ScalatestRouteTest {
  import io.circe.generic.auto._

  "GET /app" should {
    "return 200" in new Routes {
      Get("/app") ~> routes ~> check {
        status shouldBe StatusCodes.OK
        responseAs[User] shouldBe User("app")
      }
    }
  }
}
