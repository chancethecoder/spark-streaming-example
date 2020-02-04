package com.elevenst.dp.ict.stream.source

import org.apache.spark.sql.DataFrame

abstract class Source {

  def readStream(): DataFrame

}
