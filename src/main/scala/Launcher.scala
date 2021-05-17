import wvlet.airframe.launcher.{Launcher, argument, command, option}
import wvlet.log.LogSupport

case class GlobalOption(
                         @option(prefix = "-h,--help", description = "display help messages", isHelp = true)
                         help: Boolean = false,
//                         @option(prefix = "-l,--loglevel", description = "log level")
//                         loglevel: Option[LogLevel] = None
                       )
class MyApp(g:GlobalOption) extends LogSupport {
//  Logger.setDefaultLogLevel(g.loglevel)

  @command(isDefault = true)
  def default {
    println("Type --help to display the list of commands")
  }

//  @command(description = "say world")
//  def world(@argument message: String) {
//    println(s"world ${message}")
//  }

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

object Launch extends App {
  Launcher.execute[MyApp]("add -p 'household' -i 'do laundry'")
}