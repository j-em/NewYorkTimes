name := "nytimes"
description := "JVM interface for the New York Times API"
version := "1.0.0"
libraryDependencies ++=  Seq(
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "io.argonaut" %% "argonaut" % "6.1",
  "org.scalaz" %% "scalaz-core" % "7.1.1",
  "org.scalaz" %% "scalaz-effect" % "7.1.1",
  "joda-time" % "joda-time" % "2.9.4",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test")
