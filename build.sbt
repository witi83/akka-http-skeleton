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

scalaSource in Compile := baseDirectory.value / "src"
scalaSource in Test := baseDirectory.value / "src-test"
resourceDirectory in Compile := baseDirectory.value / "resources"
resourceDirectory in Test := baseDirectory.value / "resources-test"

libraryDependencies ++= {
  lazy val akkaV = "2.4.11"
  lazy val circeV = "0.5.2"

  lazy val testDeps = Seq(
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV % Test,
    "org.scalatest" %% "scalatest" % "3.0.0" % Test
  )

  lazy val runtimeDeps = Seq(
    "com.typesafe.akka" %% "akka-slf4j" % akkaV % Runtime,
    "ch.qos.logback" % "logback-classic" % "1.1.7" % Runtime
  )

  lazy val baseDeps = Seq(
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "de.heikoseeberger" %% "akka-http-circe" % "1.10.1",
    "io.circe" %% "circe-generic" % circeV,
    "org.slf4j" % "slf4j-api" % "1.7.21"
  )

  baseDeps ++ testDeps ++ runtimeDeps
}

Revolver.settings
