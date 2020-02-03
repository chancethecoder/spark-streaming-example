package com.elevenst.dp.ict

import org.apache.log4j.Logger

trait LazyLogging {
  protected lazy val log:Logger = Logger.getLogger(getClass.getName)
}
