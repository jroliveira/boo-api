package com.jroliveira.boo.infra

import com.jroliveira.boo.components._
import com.jroliveira.boo.infra.data.DataSourceInMemoryComponent

object ComponentRegistry extends DataSourceInMemoryComponent
  with CreateToggleComponent
  with GetTogglesComponent
  with CreateUserComponent
  with GetUsersComponent
  with GetUserComponent {
  val dataSource = new DataSourceInMemory

  val createToggle = new CreateToggle
  val getToggles = new GetToggles

  val createUser = new CreateUser
  val getUser = new GetUser
  val getUsers = new GetUsers
}