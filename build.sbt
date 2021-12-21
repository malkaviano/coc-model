import Dependencies._

ThisBuild / scalaVersion := "2.13.7"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.github.malkaviano"
ThisBuild / organizationName := "rkss"

ThisBuild / scalacOptions ++= Seq(
  "-encoding",
  "utf8",
  "-deprecation",
  "-unchecked",
  "-Xlint",
  "-feature",
  "-language:existentials",
  "-language:experimental.macros",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Yrangepos",
  "-Xfatal-warnings"
)

lazy val root = (project in file("."))
  .settings(
    name := "coc-concepts",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
