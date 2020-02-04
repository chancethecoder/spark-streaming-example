package com.elevenst.dp.ict.config

import com.typesafe.config.Config

import scala.collection.JavaConverters._

case class AppConfig(conf: Config) {
  val env: String = conf.getString("env")
  val spark = new SparkAppElement(conf.getConfig("spark"))
  val kafka = new KafkaElement(conf.getConfig("kafka"))
}

class SparkAppElement(conf: Config) {
  val name: String = conf.getString("name")
  val master: String = conf.getString("master")
}

class KafkaElement(conf: Config) {
  val servers: String = conf.getStringList("bootstrap.servers").asScala.mkString(",")
  val groupId: String = conf.getString("group_id")
  val topic: String = conf.getString("topic")
}