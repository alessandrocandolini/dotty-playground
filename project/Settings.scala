import sbt._
import Keys._

object Settings {

  val commonSettings: Seq[Def.Setting[_]] = Seq(
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-language:strictEquality",
      "-Yexplicit-nulls",
      "-Ycheck-init"
      )
  ) 

}

object Dependencies {

  val scalaDependencies = Seq(
    "org.typelevel" %% "cats-core" % Versions.cats, // available for dotty, but incompatible with the one imported by the other libs 
    "com.softwaremill.sttp.tapir" %% "tapir-core" % Versions.tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % "0.17.0-M8",
    "dev.zio" %% "zio" % Versions.zio,
  )

  val dependencies = Seq(
  )
  
  val testDependencies = Seq(
    "org.scalacheck" %% "scalacheck" % Versions.scalacheck
  ).map(_ % Test)

}

object Versions {
  val scalacheck = "1.15.1"
  val cats = "2.3.0-M2"
  val tapir = "0.16.16"
  //val circeVersion = "0.14.0-M1" only supports v0.26.0-RC1
  val zio = "1.0.3"
  //val skunk = "0.0.18"
}
