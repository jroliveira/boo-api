package com.jroliveira.boo

import com.jroliveira.boo.components._
import com.jroliveira.boo.infra.data.MongoDbComponent
import com.mongodb.casbah.MongoCollection
import org.specs2.mock.Mockito

trait TestEnvironment extends MongoDbComponent
  with CreateUserComponent
  with GetUserComponent
  with GetUsersComponent
  with CreateToggleComponent
  with GetTogglesComponent
  with Mockito {
  val mongoCollection: MongoCollection = mock[MongoCollection]

  val mongoDb: MongoDb = mock[MongoDb]
  mongoDb.collection("users") returns mongoCollection
  mongoDb.collection("toggles") returns mongoCollection

  val createToggle = new CreateToggle
  val getToggles = new GetToggles

  val createUser = new CreateUser
  val getUser = new GetUser
  val getUsers = new GetUsers
}
