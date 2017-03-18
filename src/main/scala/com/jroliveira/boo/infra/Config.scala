package com.jroliveira.boo.infra

import com.typesafe.config.ConfigFactory

trait Config {
  private val config = ConfigFactory.load()

  private val httpConfig = config.getConfig("http")
  protected val httpInterface: String = httpConfig.getString("interface")
  protected val httpPort: Int = httpConfig.getInt("port")

  private val mongoConfig = config.getConfig("mongo")
  protected val mongoHost: String = mongoConfig.getString("host")
  protected val mongoPort: Int = mongoConfig.getInt("port")
  protected val mongoDatabase: String = mongoConfig.getString("database")
}
