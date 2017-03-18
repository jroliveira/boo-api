package com.jroliveira.boo.components

import com.jroliveira.boo.models.User
import com.jroliveira.boo.{BaseSpec, TestEnvironment}
import com.mongodb.casbah.commons.MongoDBObject

import scala.concurrent.Await
import scala.concurrent.duration._

class GetUserSpec extends BaseSpec {
  val testEnvironment = new TestEnvironment

  "GetUser" should {
    testEnvironment
      .mongoCollection
      .findOne(MongoDBObject("name" -> "jroliveira"))
      .returns(Some(MongoDBObject("name" -> "jroliveira")))
    val user = get("jroliveira").get

    "return name equal to 'jroliveira'" in {
      user.name must beEqualTo("jroliveira")
    }
  }

  def get(name: String): Option[User] = Await.result(testEnvironment.getUser(name), Duration.Inf)
}