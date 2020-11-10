import Dependencies._
import Settings._

ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / organization := "dotty-playground"
ThisBuild / scalaVersion := "0.27.0-RC1" 
//ThisBuild / scalaVersion := "3.0.0-M1"  // zio not available for 3.0.0-M1 yet 

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= 
    scalaDependencies.map(_.withDottyCompat(scalaVersion.value)) ++ dependencies ++ testDependencies
  )





