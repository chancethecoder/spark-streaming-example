package com.elevenst.dp.ict

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.spark.sql.SparkSession

object Main extends App with LazyLogging {

  val config: Config = ConfigFactory.load("config/local.conf")
  val settings: Settings = new Settings(config)

  val spark = SparkSession
    .builder
    .appName(settings.sparkAppName)
    .master(settings.sparkMaster)
    .getOrCreate

  new Main(spark, settings).run

}

class Main(spark: SparkSession, settings: Settings) extends Serializable with LazyLogging {

  def run(): Unit = {
    log.info("Application Start")

    val records = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", settings.kafkaBootstrapServers)
      .option("subscribe", settings.kafkaSubscribe)
      .load

    val messages = records
      .selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")

    log.debug(messages)

    val query = messages.writeStream
      .format("console")
      .start

    query.awaitTermination()
  }

}