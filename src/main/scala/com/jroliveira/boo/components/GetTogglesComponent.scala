package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.MongoDbComponent
import com.jroliveira.boo.models.{Toggle, User}

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.MongoDBObject
import salat._
import salat.global._

import scala.concurrent.Future

trait GetTogglesComponent extends Component {
  this: MongoDbComponent =>
  val getToggles: GetToggles

  class GetToggles {
    def apply(user: User,
              name: Option[String],
              tags: Option[Seq[String]]): Future[Seq[Toggle]] = Future {
      val builder = MongoDBObject.newBuilder

      builder += "user" -> user.name
      if (name.isDefined) builder += "name" -> name.get
      if (tags.isDefined) builder += ("tags" -> MongoDBObject("$in" -> tags.get))

      mongoDb
        .collection("toggles")
        .find(builder.result)
        .map(grater[Toggle].asObject(_))
        .toList
    }
  }

}
