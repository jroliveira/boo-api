package com.jroliveira.boo.infra

import com.jroliveira.boo.components._
import com.jroliveira.boo.infra.data.MongoDbComponentImpl

object ComponentRegistry extends MongoDbComponentImpl
  with CreateToggleComponent
  with GetTogglesComponent
  with CreateUserComponent
  with GetUsersComponent
  with GetUserComponent {
  val mongoDb = new Casbah

  val createToggle = new CreateToggle
  val getToggles = new GetToggles

  val createUser = new CreateUser
  val getUser = new GetUser
  val getUsers = new GetUsers
}