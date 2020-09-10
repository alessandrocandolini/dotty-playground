import Dependencies._
import Settings._

ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / organization := "dotty-playground"
ThisBuild / scalaVersion := "0.26.0-RC1" // zio is not available yet for 0.27

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= 
    (scalaDependencies ++ scalaTestDependencies).map(_.withDottyCompat(scalaVersion.value)) ++ dependencies 
  )





