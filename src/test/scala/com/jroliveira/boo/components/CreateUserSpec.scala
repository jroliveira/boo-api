package com.jroliveira.boo.components

import com.jroliveira.boo.models.User
import com.jroliveira.boo.{BaseSpec, TestEnvironment}

import scala.concurrent.Await
import scala.concurrent.duration._

class CreateUserSpec extends BaseSpec with TestEnvironment {
  "CreateUser" should {
    "return name equal to 'jroliveira'" in {
      user.name must beEqualTo("jroliveira")
    }
  }

  def user: User = {
    Await.result(createUser(User("jroliveira")), Duration.Inf)
  }
}