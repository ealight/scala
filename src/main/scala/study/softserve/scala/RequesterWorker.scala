package study.softserve.scala

import akka.actor.{Actor, ActorSystem}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest}
import akka.stream.ActorMaterializer
import org.json4s._
import org.json4s.jackson.JsonMethods._
import study.softserve.scala.JSONParser.CityWeather

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class RequesterWorker extends Actor {
  implicit val system: ActorSystem = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val formats: DefaultFormats.type = DefaultFormats

  def receive: Receive = {
    case city => {
      import system.dispatcher

      val responseFuture = Http().singleRequest(
        HttpRequest(
          method = HttpMethods.GET,
          uri = s"https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$openWeatherApiKey",
        )
      )

      responseFuture
        .flatMap(_.entity.toStrict(2 seconds))
        .map(_.data.utf8String)
        .map(response => parse(response)
          .camelizeKeys
          .extract[CityWeather])
          .foreach(println)

    }
  }
}