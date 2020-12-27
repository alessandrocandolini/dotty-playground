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
    "org.typelevel" %% "cats-core" % Versions.cats, 
"org.typelevel" %% "cats-effect" % Versions.cats,
    "com.softwaremill.sttp.tapir" %% "tapir-core" % Versions.tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % "0.17.0-M8",
    "dev.zio" %% "zio" % Versions.zio,
    "org.tpolecat" %% "skunk-macros" % Versions.skunk,

  )

  val dependencies = Seq(
  )
  
  val testDependencies = Seq(
    "org.scalacheck" %% "scalacheck" % Versions.scalacheck
  ).map(_ % Test)

}

object Versions {
  val scalacheck = "1.15.2"
  val cats = "2.3.1"
  val tapir = "0.17.1"
  val zio = "1.0.3"
  val skunk = "0.0.22-M2"
}
