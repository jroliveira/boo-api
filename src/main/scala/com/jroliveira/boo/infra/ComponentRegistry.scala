package com.jroliveira.boo.infra

import com.jroliveira.boo.components._

object ComponentRegistry extends CreateToggleComponent
  with GetTogglesComponent
  with CreateUserComponent
  with GetUsersComponent
  with GetUserComponent {
  val createToggle = new CreateToggle
  val getToggles = new GetToggles
  val createUser = new CreateUser
  val getUsers = new GetUsers
  val getUser = new GetUser
}