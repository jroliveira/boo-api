package com.jroliveira.boo.components

import scala.concurrent.ExecutionContext.Implicits
import scala.concurrent.ExecutionContext

trait Component {
  implicit val ec: ExecutionContext = Implicits.global
}
