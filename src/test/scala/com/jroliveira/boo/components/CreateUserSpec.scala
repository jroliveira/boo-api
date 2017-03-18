package com.jroliveira.boo.components

import com.jroliveira.boo.models.User
import com.jroliveira.boo.{BaseSpec, TestEnvironment}

import scala.concurrent.Await
import scala.concurrent.duration._

class CreateUserSpec extends BaseSpec {
  val testEnvironment = new TestEnvironment

  "CreateUser" should {
    val user = create

    "return name equal to 'jroliveira'" in {
      user.name must beEqualTo("jroliveira")
    }
  }

  def create: User = Await.result(testEnvironment.createUser(User("jroliveira")), Duration.Inf)
}