package com.github.despinaki.view

import wvlet.airframe.launcher.{command, option}
import wvlet.log.LogSupport


class MyApp(g:GlobalOption) extends LogSupport {
//  Logger.setDefaultLogLevel(g.loglevel)

  @command(isDefault = true)
  def default {
    println("Type --help to display the list of commands")
  }

  @command(description = "Add a to-do item in a project.")
  def add(
             @option(prefix="-p,--project", description = "project")
             project:Option[String] = None,
             @option(prefix="-i,--item",description = "task item")
             item:Option[String] = None
           ) {
//    val item = host.getOrElse("lots of things to do!")

    println(s"Adding item '${item.get}' to project '${project.get}'.")
  }
}