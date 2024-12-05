name := """sandbox-scala-play"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.15"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint",
  "-Wconf:src=target/.*:silent"
)

semanticdbEnabled := true
semanticdbVersion := scalafixSemanticdb.revision

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play-slick" % "5.1.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.1.0",
  "com.mysql" % "mysql-connector-j" % "8.1.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.1" % Test,
  "org.mockito" % "mockito-core" % "5.6.0" % Test
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
