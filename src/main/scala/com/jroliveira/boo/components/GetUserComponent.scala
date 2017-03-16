package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.MongoDbComponent
import com.jroliveira.boo.models.User

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.MongoDBObject
import salat._
import salat.global._

import scala.concurrent.Future

trait GetUserComponent extends Component {
  this: MongoDbComponent =>
  val getUser: GetUser

  class GetUser {
    def apply(name: String): Future[Option[User]] = Future {
      mongoDb
        .collection("users")
        .findOne(MongoDBObject("name" -> name))
        .map(grater[User].asObject(_))
    }
  }

}
