package com.jroliveira.boo

import com.jroliveira.boo.components._
import com.jroliveira.boo.infra.data.MongoDbComponent
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.{MongoCollection, MongoCursor}
import org.specs2.mock.Mockito

class TestEnvironment extends MongoDbComponent
  with CreateUserComponent
  with GetUserComponent
  with GetUsersComponent
  with CreateToggleComponent
  with GetTogglesComponent
  with Mockito {
  val mongoCursor: MongoCursor = mock[MongoCursor]

  val mongoCollection: MongoCollection = mock[MongoCollection]
  mongoCollection find() returns mongoCursor
  mongoCollection find MongoDBObject("user" -> "jroliveira") returns mongoCursor

  val mongoDb: MongoDb = mock[MongoDb]
  mongoDb collection "users" returns mongoCollection
  mongoDb collection "toggles" returns mongoCollection

  val createToggle = new CreateToggle
  val getToggles = new GetToggles

  val createUser = new CreateUser
  val getUser = new GetUser
  val getUsers = new GetUsers
}