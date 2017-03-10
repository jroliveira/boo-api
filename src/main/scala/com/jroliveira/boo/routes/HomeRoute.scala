package com.jroliveira.boo.routes

import akka.http.scaladsl.server.Route

object HomeRoute extends BaseRoute {
  val routes: Route =
    path("") {
      get {
        complete {
          Map("message" -> "I'm working...")
        }
      }
    }
}
