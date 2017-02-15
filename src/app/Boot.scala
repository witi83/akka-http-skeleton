package app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import de.heikoseeberger.akkahttpcirce.CirceSupport._
import io.circe.generic.auto._
import org.slf4j.LoggerFactory

object Boot extends Routes {
  implicit val config = ConfigFactory.load()
  implicit val system = ActorSystem("app", config)
  implicit val mat = ActorMaterializer()
  implicit val ec = system.dispatcher

  def main(args: Array[String]): Unit = {
    Http().bindAndHandle(routes, config.getString("http.interface"), config.getInt("http.port"))

    sys addShutdownHook system.terminate().foreach(LoggerFactory.getLogger("Main").info("terminated {}", _))
    ()
  }
}

trait Routes {
  val routes = path("app") {
    get {
      complete(User("app"))
    }
  }
}

final case class User(name: String)
