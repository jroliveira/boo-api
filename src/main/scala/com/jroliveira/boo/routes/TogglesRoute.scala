package com.jroliveira.boo.routes

import akka.http.scaladsl.model.StatusCodes.Created
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.PredefinedFromStringUnmarshallers.CsvSeq
import com.jroliveira.boo.infra.ComponentRegistry
import com.jroliveira.boo.models.Toggle
import spray.json.RootJsonFormat

object TogglesRoute extends BaseRoute {
  implicit val format: RootJsonFormat[Toggle] = jsonFormat3(Toggle)

  val routes: Route =
    pathPrefix("users" / Segment / "toggles") { user =>
      pathEnd {
        post(createToggle(user)) ~
          get(getToggle(user))
      } ~
        path(Segment) { name =>
          get(getToggle(user, Some(name)))
        }
    }

  private def createToggle(userName: String): Route = {
    entity(as[Toggle]) { model =>
      val getUser = ComponentRegistry.getUser
      val createToggle = ComponentRegistry.createToggle

      val done =
        for {
          user <- getUser(userName)
          toggle <- createToggle(user.get, model)
        } yield toggle

      onSuccess(done)(toggle => rejectEmptyResponse(complete(Created, toggle)))
    }
  }

  private def getToggle(userName: String, name: Option[String] = None): Route = {
    parameters('tags.as(CsvSeq[String]).?) { tags =>
      val getUser = ComponentRegistry.getUser
      val getToggles = ComponentRegistry.getToggles

      val done =
        for {
          user <- getUser(userName)
          toggles <- getToggles(user.get, name, tags)
        } yield toggles

      onSuccess(done)(toggles => rejectEmptyResponse(complete(toggles)))
    }
  }
}
