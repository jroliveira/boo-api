package com.jroliveira.boo.routes

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives
import spray.json.DefaultJsonProtocol

import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits

trait RouteBase extends Directives
  with SprayJsonSupport
  with DefaultJsonProtocol {
  implicit val ec: ExecutionContext = Implicits.global
}
