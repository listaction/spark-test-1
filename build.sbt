name := """spark-test-1"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.apache.spark"  %% "spark-core"              % "1.6.1",
  "com.typesafe.akka" %% "akka-actor"              % "2.4.4", 
  "com.typesafe.akka" %% "akka-slf4j"              % "2.4.4",
  "org.apache.spark"  %% "spark-sql"               % "1.6.1",
  "org.apache.spark"  %% "spark-mllib"             % "1.6.1"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
