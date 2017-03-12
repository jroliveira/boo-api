package com.jroliveira.boo.components

import com.jroliveira.boo.{BaseSpec, TestEnvironment}
import com.jroliveira.boo.models.Toggle

import scala.concurrent.Await
import scala.concurrent.duration._

class CreateToggleSpec extends BaseSpec with TestEnvironment {
  "CreateToggle" should {
    dataSource.toggles += ("jroliveira" -> List[Toggle]())

    "return name equal to 'jroliveira'" in {
      toggle.get.name must beEqualTo("isTest")
    }
    "return value equal to true" in {
      toggle.get.value must beTrue
    }
    "return tags equal to ['boo']" in {
      toggle.get.tags must beEqualTo(Seq("boo"))
    }
  }

  def toggle: Option[Toggle] = {
    Await.result(createToggle("jroliveira", Toggle("isTest", value = true, Seq("boo"))), Duration.Inf)
  }
}