package com.elevenst.dp.ict.config

import com.typesafe.config.{Config, ConfigFactory}

object LoadConfiguration {

  def apply(): Config = {
    val path = System.getProperty("config.resource", "local.conf")
    ConfigFactory.load(path)
  }

}
