package com.jroliveira.boo

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.{ActorMaterializer, Materializer}
import com.jroliveira.boo.infra.Config
import com.jroliveira.boo.routes.Router

import scala.concurrent.ExecutionContextExecutor

object Main extends Config {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("boo")
    implicit val materialize: Materializer = ActorMaterializer()
    implicit def executor: ExecutionContextExecutor = system.dispatcher

    Http().bindAndHandle(Router.routes, httpInterface, httpPort)
    println(s"Server online at http://$httpInterface:$httpPort/")
  }
}
