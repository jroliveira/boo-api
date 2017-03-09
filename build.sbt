name := "boo-api"
version := "1.0"
scalaVersion := "2.12.1"

libraryDependencies ++= {
  val akkaVersion = "2.4.17"

  Seq(
    // akka core
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
    // akka http
    "com.typesafe.akka" %% "akka-http" % "10.0.4",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.4"
  )
}

