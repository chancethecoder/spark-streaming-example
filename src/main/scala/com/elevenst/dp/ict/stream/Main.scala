package com.elevenst.dp.ict.stream

import com.elevenst.dp.ict.config.{AppConfig, LoadConfiguration}
import com.elevenst.dp.ict.helper.Logging
import com.elevenst.dp.ict.stream.sink.ConsoleSink
import com.elevenst.dp.ict.stream.source.KafkaSource
import org.apache.spark.sql.SparkSession

object Main extends App with Logging {

  val conf = AppConfig(LoadConfiguration())

  val spark = SparkSession
    .builder
    .appName(conf.spark.name)
    .master(conf.spark.master)
    .getOrCreate

  new Main(spark, conf).run

}

class Main(spark: SparkSession, conf: AppConfig) extends Serializable with Logging {

  def run(): Unit = {
    val source = new KafkaSource(spark, conf)
    val sink = conf.env match {
      case "local" => new ConsoleSink
      case _ => throw new RuntimeException("No valid environment")
    }

    val df = source.readStream

    sink.writeStream(df)
  }

}