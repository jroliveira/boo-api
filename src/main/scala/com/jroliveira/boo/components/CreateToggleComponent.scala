package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.MongoDbComponent
import com.jroliveira.boo.models.{Toggle, User}

import salat._
import salat.global._

import scala.concurrent.Future

trait CreateToggleComponent extends Component {
  this: MongoDbComponent =>
  val createToggle: CreateToggle

  class CreateToggle {
    def apply(user: User, toggle: Toggle): Future[Toggle] = Future {
      val doc = ToggleDoc(user.name, toggle.name, toggle.value, toggle.tags)

      mongoDb.collection("toggles") += grater[ToggleDoc].asDBObject(doc)
      toggle
    }
  }

}

final case class ToggleDoc(user: String,
                           name: String,
                           value: Boolean,
                           tags: Seq[String])
