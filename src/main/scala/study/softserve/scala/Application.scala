package study.softserve.scala

import akka.actor.{ActorSystem, Props}

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object Application {
  def main(args: Array[String]): Unit = {
    import system.dispatcher

    val system: ActorSystem = ActorSystem("RequesterCreator")
    val creator = system.actorOf(Props[RequesterCreator], "RequesterCreator")

    system.scheduler.schedule(0 millis, 1 minute) {
      println("--------------------------------------------")
      for (city <- cities)
        creator ! city
    }

  }
}
