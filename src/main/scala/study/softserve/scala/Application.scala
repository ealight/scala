package study.softserve.scala

<<<<<<< HEAD
import akka.actor.{ActorRef, Props}
import akka.pattern.ask
import akka.routing.RoundRobinPool
import akka.util.Timeout
import study.softserve.scala.JSONParser.CityWeather

import scala.concurrent.ExecutionContextExecutor
=======
import akka.actor.{ActorSystem, Props}

>>>>>>> parent of ef52027... added communication between actors / added sort by temperature
import scala.concurrent.duration.DurationInt
import scala.language.{implicitConversions, postfixOps}

object Application {
<<<<<<< HEAD

  def main(args: Array[String]): Unit = {
    implicit val timeout: Timeout = Timeout(apiResponseTimeout seconds)
    implicit val contx: ExecutionContextExecutor = system.dispatcher

    val actors: ActorRef = system.actorOf(RoundRobinPool(cities.size).props(Props[RequestActor]), "ActorPool")

    system.scheduler.schedule(0 millis, schedulerTimeout minute) {
      println("--------------------------------------------------")
      val futures = for (city <- cities) yield actors ? city

      system.scheduler.scheduleOnce(apiResponseTimeout seconds) {
        val cont = futures
          .flatMap(future =>
            future
              .mapTo[CityWeather]
              .value
              .map(x => x.get))

        val sorted = cont.sortBy(_.main.temp)

        sorted.foreach(println)
      }
=======
  def main(args: Array[String]): Unit = {
    import system.dispatcher

    val system: ActorSystem = ActorSystem("RequesterCreator")
    val creator = system.actorOf(Props[RequestDispatcher], "RequesterCreator")

    system.scheduler.schedule(0 millis, 1 minute) {
      println("---------------------------------------------")
      for (city <- cities)
        creator ! city
>>>>>>> parent of ef52027... added communication between actors / added sort by temperature
    }

  }
}
