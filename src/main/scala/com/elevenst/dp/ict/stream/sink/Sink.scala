package com.elevenst.dp.ict.stream.sink

import org.apache.spark.sql.DataFrame

abstract class Sink {

  def writeStream(df: DataFrame): Unit

}
