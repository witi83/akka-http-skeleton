name := "app"
organization := "organization"
version := "0.1"
scalaVersion := "2.11.8"

scalacOptions := Seq("-deprecation",
                     "-encoding", "utf8",
                     "-feature",
                     "-target:jvm-1.8",
                     "-unchecked",
                     "-Yinline-warnings",
                     "-Yno-adapted-args",
                     "-Ywarn-dead-code",
                     "-Ywarn-numeric-widen",
                     "-Ywarn-value-discard",
                     "-Xfatal-warnings",
                     "-Xfuture")

crossPaths := false
fork := true
autoScalaLibrary := false

scalaSource in Compile := baseDirectory.value / "src"
scalaSource in Test := baseDirectory.value / "src-test"
resourceDirectory in Compile := baseDirectory.value / "resources"
resourceDirectory in Test := baseDirectory.value / "resources-test"

libraryDependencies ++= {
  lazy val akkaV = "10.0.3"
  lazy val circeV = "0.7.0"

  lazy val testDeps = Seq(
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV % Test,
    "org.scalatest" %% "scalatest" % "3.0.1" % Test
  )

  lazy val runtimeDeps = Seq(
    "com.typesafe.akka" %% "akka-slf4j" % "2.4.17" % Runtime,
    "ch.qos.logback" % "logback-classic" % "1.2.1" % Runtime
  )

  lazy val baseDeps = Seq(
    "com.typesafe.akka" %% "akka-http" % akkaV,
    "de.heikoseeberger" %% "akka-http-circe" % "1.12.0",
    "io.circe" %% "circe-generic" % circeV,
    "org.slf4j" % "slf4j-api" % "1.7.23"
  )

  baseDeps ++ testDeps ++ runtimeDeps
}

Revolver.settings
