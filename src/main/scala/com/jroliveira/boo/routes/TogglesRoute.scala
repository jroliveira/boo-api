package com.jroliveira.boo.routes

import akka.http.scaladsl.model.StatusCodes.Created
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.PredefinedFromStringUnmarshallers.CsvSeq

import com.jroliveira.boo.infra.ComponentRegistry
import com.jroliveira.boo.models.Toggle
import spray.json.RootJsonFormat

object TogglesRoute extends RouteBase {
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

  private def createToggle(user: String): Route = {
    entity(as[Toggle]) { model =>
      onSuccess(ComponentRegistry.createToggle(user, model))(toggle => rejectEmptyResponse(complete(Created, toggle)))
    }
  }

  private def getToggle(user: String, name: Option[String] = None): Route = {
    parameters('tags.as(CsvSeq[String]).?) { tags =>
      onSuccess(ComponentRegistry.getToggles(user, name, tags))(toggles => rejectEmptyResponse(complete(toggles)))
    }
  }
}
