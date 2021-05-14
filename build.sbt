name := "to-do-cli"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "com.typesafe.slick"  %% "slick"                % "3.3.3",
  "com.typesafe.slick"  %% "slick-hikaricp"       % "3.3.3",
  "org.slf4j"           %  "slf4j-nop"            % "1.6.4",
  "org.xerial"          %  "sqlite-jdbc"          % "3.34.0"
)