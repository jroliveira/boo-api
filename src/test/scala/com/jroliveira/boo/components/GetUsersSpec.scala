package com.jroliveira.boo.components

import com.jroliveira.boo.models.User
import com.jroliveira.boo.{BaseSpec, TestEnvironment}

import scala.concurrent.Await
import scala.concurrent.duration._

class GetUsersSpec extends BaseSpec {
  val testEnvironment = new TestEnvironment

  "GetUsers" should {
    testEnvironment
      .mongoCursor
      .map(_ => User("jroliveira"))
      .returns(Iterator(User("jroliveira")))
    val users = get

    "return length equal to 1" in {
      users.length must beEqualTo(1)
    }
    "return name of first item equal to 'jroliveira'" in {
      users.head.name must beEqualTo("jroliveira")
    }
  }

  def get: Seq[User] = Await.result(testEnvironment.getUsers(), Duration.Inf)
}