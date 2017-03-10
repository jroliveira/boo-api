package com.jroliveira.boo.routes

import akka.http.scaladsl.model.StatusCodes.Created
import akka.http.scaladsl.server.Route

import com.jroliveira.boo.infra.ComponentRegistry
import com.jroliveira.boo.models.User
import spray.json.RootJsonFormat

object UsersRoute extends BaseRoute {
  implicit val format: RootJsonFormat[User] = jsonFormat1(User)

  val routes: Route =
    pathPrefix("users") {
      pathEnd {
        post {
          entity(as[User]) { model =>
            onSuccess(ComponentRegistry.createUser(model))(user => complete(Created, user))
          }
        } ~
          get {
            onSuccess(ComponentRegistry.getUsers())(users => complete(users))
          }
      } ~
        path(Segment) { name =>
          get {
            onSuccess(ComponentRegistry.getUser(name))(user => rejectEmptyResponse(complete(user)))
          }
        }
    }
}
