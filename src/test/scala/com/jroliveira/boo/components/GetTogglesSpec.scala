package com.jroliveira.boo.components

import com.jroliveira.boo.models.Toggle
import com.jroliveira.boo.{BaseSpec, TestEnvironment}

import scala.concurrent.Await
import scala.concurrent.duration._

class GetTogglesSpec extends BaseSpec with TestEnvironment {
  "GetToggles" should {
    dataSource.toggles += ("jroliveira" -> List[Toggle](Toggle("isTest", value = true, Seq("boo"))))

    "return length equal to 1" in {
      toggles.get.length must beEqualTo(1)
    }
    "return name of first item equal to 'isTest'" in {
      toggles.get.head.name must beEqualTo("isTest")
    }
    "return value of first item equal to true" in {
      toggles.get.head.value must beTrue
    }
    "return tags of first item equal to ['boo']" in {
      toggles.get.head.tags must beEqualTo(Seq("boo"))
    }
  }

  def toggles: Option[Seq[Toggle]] = {
    Await.result(getToggles("jroliveira", Some("isTest"), Some(Seq("boo"))), Duration.Inf)
  }
}