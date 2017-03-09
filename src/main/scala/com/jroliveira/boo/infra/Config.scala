package com.jroliveira.boo.infra

import com.typesafe.config.ConfigFactory

trait Config {
  private val config = ConfigFactory.load()

  private val httpConfig = config.getConfig("http")
  protected val httpInterface: String = httpConfig.getString("interface")
  protected val httpPort: Int = httpConfig.getInt("port")
}
