name := "boo-api"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= {
  val akkaVersion = "2.4.17"
  val akkaHttpVersion = "10.0.4"

  Seq(
    // akka core
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
    // akka http
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    // testing
    "org.specs2" %% "specs2-core" % "3.8.9" % "test",
    "org.specs2" %% "specs2-mock" % "3.8.9" % "test",
    "org.mockito" % "mockito-core" % "1.8.5",
    // mongodb
    "org.mongodb" % "casbah_2.11" % "3.1.1",
    "com.github.salat" % "salat_2.11" % "1.10.0",
	// log
    "org.slf4j" % "slf4j-simple" % "1.6.4"
  )
}