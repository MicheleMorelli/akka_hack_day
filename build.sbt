name := "akka_hack_day"

version := "0.1"

scalaVersion := "2.13.3"

val AkkaVersion = "2.6.8"
libraryDependencies ++=
  Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-remote" % AkkaVersion
  )