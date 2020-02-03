package com.elevenst.dp.ict

import com.typesafe.config.Config

class Settings(config: Config) extends Serializable {

  val sparkAppName = config.getString("spark.app_name")
  val sparkMaster = config.getString("spark.master")

  val kafkaBootstrapServers = config.getString("kafka.bootstrap.servers")
  val kafkaSubscribe = config.getString("kafka.subscribe")

}
