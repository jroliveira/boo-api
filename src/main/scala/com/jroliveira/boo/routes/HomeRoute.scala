package com.jroliveira.boo.routes

import akka.http.scaladsl.server.Route

object HomeRoute extends RouteBase {
  val routes: Route =
    path("") {
      get {
        complete {
          Map("message" -> "I'm working...")
        }
      }
    }
}
