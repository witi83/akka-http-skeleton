name := "app"
organization := "organization"
version := "0.2"

scalacOptions := Seq("-deprecation",
                     "-encoding", "utf8",
                     "-feature",
                     "-target:jvm-1.8",
                     "-unchecked",
                     "-Yno-adapted-args",
                     "-Ywarn-dead-code",
                     "-Ywarn-numeric-widen",
                     "-Ywarn-value-discard",
                     "-Xfatal-warnings",
                     "-Xfuture")

crossPaths := false
autoScalaLibrary := false

scalaSource in Compile := baseDirectory.value / "src"
scalaSource in Test := baseDirectory.value / "src-test"
resourceDirectory in Compile := baseDirectory.value / "resources"
resourceDirectory in Test := baseDirectory.value / "resources-test"

libraryDependencies ++= {
  lazy val akkaV = "10.0.5"
  lazy val circeV = "0.7.1"

  lazy val testDeps = Seq(
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV % Test,
    "org.scalatest" %% "scalatest" % "3.0.2" % Test
  )

  lazy val runtimeDeps = Seq(
    "com.typesafe.akka" %% "akka-slf4j" % "2.5.0" % Runtime,
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Runtime
  )

  lazy val baseDeps = Seq(
    "com.typesafe.akka" %% "akka-http" % akkaV,
    "de.heikoseeberger" %% "akka-http-circe" % "1.15.0",
    "io.circe" %% "circe-generic" % circeV,
    "org.slf4j" % "slf4j-api" % "1.7.25"
  )

  baseDeps ++ testDeps ++ runtimeDeps
}

Revolver.settings
