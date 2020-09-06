val dottyVersion = "0.27.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-playground",
    version := "0.1.0",
    scalaVersion := dottyVersion,
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-language:strictEquality"
    ),
    libraryDependencies ++= dependencies
  )


val dependencies = {
  val scalacheck = "1.14.3"
  Seq(
    "org.scalacheck" % "scalacheck_2.13" % scalacheck % Test
  )
}