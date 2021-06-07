package study.softserve.scala

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

import scala.io.StdIn

object Application {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem(Behaviors.empty, "my-system")

    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.executionContext
    val port = 8080
    val route = concat(
      pathPrefix("atm" / Segment) { atmId =>
        concat(
          path("cash") {
            concat(
              get {
                // gets info about remaining notes in cash
                complete(s"atm $atmId ok")
              },
              post {
                // loads cash notes into atm
                complete(s"atm $atmId ok")
              }
            )
          },
          get {
            // get atm info
            complete(s"atm get with id $atmId")
          },
          post {
            // create atm
            complete(s"atm create with id $atmId")
          }
        )
      },
      pathPrefix("user" / Segment) { userId =>
        path("cash") {
          concat(
            get {
              complete(s"$userId ok")
            },
            post {
              complete(s"$userId ok")
            }
          )
        }
      },
      pathPrefix("statistics") {
        get {
          complete("Statictics page")
        }
      }
    )

    val bindingFuture = Http().newServerAt("localhost", port).bind(route)

    println(s"Server online at http://localhost:$port/\nPress RETURN to stop...")

    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done

  }

}
