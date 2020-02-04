package com.elevenst.dp.ict.helper

import org.apache.log4j.Logger

trait Logging {

  protected lazy val log: Logger = Logger.getLogger(getClass.getName)

}
