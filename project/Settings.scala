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
    "com.softwaremill.sttp.tapir" %% "tapir-core" % Versions.tapir,
    "org.tpolecat" %% "skunk-core" % Versions.skunk
  )

  val dependencies = Seq(
    "dev.zio" %% "zio" % Versions.zio
  )
  
  val testDependencies = Seq(
    "org.scalacheck" %% "scalacheck" % Versions.scalacheck
  ).map(_ % Test)

}

object Versions {
  val scalacheck = "1.15.1"
  val tapir = "0.16.16"
  //val circeVersion = "0.14.0-M1" only supports v0.26.0-RC1
  val zio = "1.0.3"
  val skunk = "0.0.18"
}
