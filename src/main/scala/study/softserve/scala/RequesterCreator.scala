package study.softserve.scala

import akka.actor.{Actor, ActorRef, Props}
import akka.routing.RoundRobinPool

class RequesterCreator extends Actor {
  val requesters: ActorRef = context.actorOf(Props[RequesterWorker].withRouter(RoundRobinPool(cities.size)), "RequesterWorkers")

  override def receive: Receive = {
    case request => {
      requesters forward request
    }
  }
}
