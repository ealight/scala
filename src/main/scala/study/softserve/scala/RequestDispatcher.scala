package study.softserve.scala

import akka.actor.{Actor, ActorRef, Props}
import akka.routing.RoundRobinPool

class RequestDispatcher extends Actor {
  val requesters: ActorRef = context.actorOf(Props[RequestActor].withRouter(RoundRobinPool(cities.size)), "RequestDispatcher")

  override def receive: Receive = {
    case request => {
      requesters forward request
    }
  }
}
