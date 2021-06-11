package com.github.despinaki.view

import wvlet.airframe.launcher.option

case class GlobalOption(
                         @option(prefix = "-h,--help", description = "display help messages", isHelp = true)
                         help: Boolean = false,
                         //                         @option(prefix = "-l,--loglevel", description = "log level")
                         //                         loglevel: Option[LogLevel] = None
                       )
