package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.MongoDbComponent
import com.jroliveira.boo.models.User

import salat._
import salat.global._

import scala.concurrent.Future

trait CreateUserComponent extends Component {
  this: MongoDbComponent =>
  val createUser: CreateUser

  class CreateUser {
    def apply(user: User): Future[User] = Future {
      mongoDb.collection("users") += grater[User].asDBObject(user)
      user
    }
  }

}
