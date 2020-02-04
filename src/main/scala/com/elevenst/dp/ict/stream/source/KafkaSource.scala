package com.elevenst.dp.ict.stream.source

import com.elevenst.dp.ict.config.AppConfig
import org.apache.spark.sql.{DataFrame, SparkSession}

object KafkaSource {

  def apply(spark: SparkSession, conf: AppConfig): KafkaSource = new KafkaSource(spark, conf)

}

class KafkaSource(spark: SparkSession, conf: AppConfig) extends Source {

  override def readStream(): DataFrame = {
    spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", conf.kafka.servers)
      .option("subscribe", conf.kafka.topic)
      .load
  }

}
