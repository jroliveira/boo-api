package com.jroliveira.boo.components

import com.jroliveira.boo.models.{Toggle, User}
import com.jroliveira.boo.{BaseSpec, TestEnvironment}

import scala.concurrent.Await
import scala.concurrent.duration._

class GetUserSpec extends BaseSpec with TestEnvironment {
  "GetUser" should {
    dataSource.toggles += ("jroliveira" -> List[Toggle]())

    "return name equal to 'jroliveira'" in {
      user("jroliveira").get.name must beEqualTo("jroliveira")
    }
  }

  def user(name: String): Option[User] = {
    Await.result(getUser(name), Duration.Inf)
  }
}