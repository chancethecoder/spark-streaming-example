package com.elevenst.dp.ict.stream.sink
import org.apache.spark.sql.DataFrame

class ConsoleSink extends Sink {

  override def writeStream(df: DataFrame): Unit = {
    df.writeStream
      .format("console")
      .start
      .awaitTermination()
  }

}
