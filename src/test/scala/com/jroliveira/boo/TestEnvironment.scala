package com.jroliveira.boo

import com.jroliveira.boo.components._
import com.jroliveira.boo.infra.data.DataSourceInMemoryComponent
import org.specs2.mock.Mockito

trait TestEnvironment extends DataSourceInMemoryComponent
  with CreateUserComponent
  with GetUserComponent
  with GetUsersComponent
  with CreateToggleComponent
  with GetTogglesComponent
  with Mockito {
  val dataSource = new DataSourceInMemory

  val createToggle = new CreateToggle
  val getToggles = new GetToggles

  val createUser = new CreateUser
  val getUser = new GetUser
  val getUsers = new GetUsers
}
