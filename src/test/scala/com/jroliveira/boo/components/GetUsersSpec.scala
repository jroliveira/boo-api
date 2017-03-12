package com.jroliveira.boo.components

import com.jroliveira.boo.models.{Toggle, User}
import com.jroliveira.boo.{BaseSpec, TestEnvironment}

import scala.concurrent.Await
import scala.concurrent.duration._

class GetUsersSpec extends BaseSpec with TestEnvironment {
  "GetUsers" should {
    dataSource.toggles += ("jroliveira" -> List[Toggle]())

    "return length equal to 1" in {
      users.length must beEqualTo(1)
    }
    "return name of first item equal to 'jroliveira'" in {
      users.head.name must beEqualTo("jroliveira")
    }
  }

  def users: Seq[User] = {
    Await.result(getUsers(), Duration.Inf)
  }
}