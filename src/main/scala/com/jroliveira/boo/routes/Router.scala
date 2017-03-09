package com.jroliveira.boo.routes

import akka.http.scaladsl.server.{Directives, Route}

object Router extends Directives {
  val routes: Route =
    HomeRoute.routes ~
      UsersRoute.routes ~
      TogglesRoute.routes
}
