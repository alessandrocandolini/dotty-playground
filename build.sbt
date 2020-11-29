import Dependencies._
import Settings._

ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / organization := "dotty-playground"
ThisBuild / scalaVersion := "3.0.0-M2" 

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= 
    scalaDependencies.map(_.withDottyCompat(scalaVersion.value)) ++ dependencies ++ testDependencies
  )





