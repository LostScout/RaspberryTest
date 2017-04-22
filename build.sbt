name := "RaspberryTest"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= List(
  "com.typesafe.akka" %% "akka-actor" % "2.5.0",
"com.typesafe.akka" %% "akka-agent" % "2.5.0",
"com.typesafe.akka" %% "akka-camel" % "2.5.0",
"com.typesafe.akka" %% "akka-cluster" % "2.5.0",
"com.typesafe.akka" %% "akka-cluster-metrics" % "2.5.0",
"com.typesafe.akka" %% "akka-cluster-sharding" % "2.5.0",
"com.typesafe.akka" %% "akka-cluster-tools" % "2.5.0",
"com.typesafe.akka" %% "akka-distributed-data" % "2.5.0",
"com.typesafe.akka" %% "akka-multi-node-testkit" % "2.5.0",
//"com.typesafe.akka" %% "akka-osgi" % "2.5.0",
"com.typesafe.akka" %% "akka-persistence" % "2.5.0",
"com.typesafe.akka" %% "akka-persistence-query" % "2.5.0",
"com.typesafe.akka" %% "akka-persistence-tck" % "2.5.0",
"com.typesafe.akka" %% "akka-remote" % "2.5.0",
"com.typesafe.akka" %% "akka-slf4j" % "2.5.0",
"com.typesafe.akka" %% "akka-stream" % "2.5.0",
"com.typesafe.akka" %% "akka-stream-testkit" % "2.5.0",
"com.typesafe.akka" %% "akka-testkit" % "2.5.0",
"com.typesafe.akka" %% "akka-typed" % "2.5.0",
"com.typesafe.akka" %% "akka-contrib" % "2.5.0"
)

libraryDependencies += "com.pi4j" % "pi4j-core" % "1.1"

lazy val commonSettings = Seq(
  version := "0.1-SNAPSHOT",
  organization := "trent",
  scalaVersion := "2.12.1",
  test in assembly := {}
)

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "fat-jar-test"
  ).
  enablePlugins(AssemblyPlugin)

resolvers in Global ++= Seq(
  "Sbt plugins"                   at "https://dl.bintray.com/sbt/sbt-plugin-releases",
  "Maven Central Server"          at "http://repo1.maven.org/maven2",
  "TypeSafe Repository Releases"  at "http://repo.typesafe.com/typesafe/releases/",
  "TypeSafe Repository Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"
)