package com.jroliveira.boo.components

import com.jroliveira.boo.models.{Toggle, User}
import com.jroliveira.boo.{BaseSpec, TestEnvironment}

import scala.concurrent.Await
import scala.concurrent.duration._

class GetTogglesSpec extends BaseSpec {
  val testEnvironment = new TestEnvironment

  "GetToggles" should {
    testEnvironment
      .mongoCursor
      .map(_ => Toggle("isTest", value = true, Seq("boo", "1.0")))
      .returns(Iterator(Toggle("isTest", value = true, Seq("boo", "1.0"))))
    val toggles = get

    "return length equal to 1" in {
      toggles.length must beEqualTo(1)
    }
    "return name of first item equal to 'isTest'" in {
      toggles.head.name must beEqualTo("isTest")
    }
    "return value of first item equal to true" in {
      toggles.head.value must beTrue
    }
    "return tags of first item equal to ['boo', '1.0']" in {
            toggles.head.tags must beEqualTo(Seq("boo", "1.0"))
    }
  }

  def get: Seq[Toggle] = Await.result(testEnvironment.getToggles(User("jroliveira"), None, None), Duration.Inf)
}