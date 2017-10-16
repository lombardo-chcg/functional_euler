name := "prime-calculator"

version := "0.0.1"

mainClass in assembly := Some("com.lombardo.app.Main")

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
