package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.MongoDbComponent
import com.jroliveira.boo.models.User

import com.mongodb.casbah.Imports._
import salat._
import salat.global._

import scala.concurrent.Future

trait GetUsersComponent extends Component {
  this: MongoDbComponent =>
  val getUsers: GetUsers

  class GetUsers {
    def apply(): Future[Seq[User]] = Future {
      mongoDb
        .collection("users")
        .find()
        .map(grater[User].asObject(_))
        .toList
    }
  }

}
