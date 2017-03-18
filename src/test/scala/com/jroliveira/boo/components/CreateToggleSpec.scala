package com.jroliveira.boo.components

import com.jroliveira.boo.{BaseSpec, TestEnvironment}
import com.jroliveira.boo.models.{Toggle, User}

import scala.concurrent.Await
import scala.concurrent.duration._

class CreateToggleSpec extends BaseSpec {
  val testEnvironment = new TestEnvironment

  "CreateToggle" should {
    val toggle = create

    "return name equal to 'jroliveira'" in {
      toggle.name must beEqualTo("isTest")
    }
    "return value equal to true" in {
      toggle.value must beTrue
    }
    "return tags equal to ['boo']" in {
      toggle.tags must beEqualTo(Seq("boo"))
    }
  }

  def create: Toggle = Await.result(testEnvironment.createToggle(User("jroliveira"), Toggle("isTest", value = true, Seq("boo"))), Duration.Inf)
}