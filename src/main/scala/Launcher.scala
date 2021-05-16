import wvlet.airframe.launcher.{Launcher, command, option}

class MyApp(@option(prefix = "-h,--help", description = "display help messages", isHelp = true)
            help: Boolean = true) {

  @command(isDefault = true)
  def default: Unit = {
    println("Type --help to display the list of commands")
  }
}

object Launch extends App {
  Launcher.execute[MyApp]("--help")
}