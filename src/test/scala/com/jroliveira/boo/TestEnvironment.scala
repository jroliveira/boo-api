package com.jroliveira.boo

import com.jroliveira.boo.components.CreateUserComponent
import com.jroliveira.boo.models.User
import org.specs2.mock.Mockito

trait TestEnvironment extends CreateUserComponent
  with Mockito {

  val fakeUser = User("jroliveira")

  val createUser = new CreateUser
}
