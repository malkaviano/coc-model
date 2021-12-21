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
  .aggregate(concepts)
  .aggregate(rules)
  .dependsOn(concepts)
  .dependsOn(rules)
  .settings(
    name := "coc-universe",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

lazy val concepts = (project in file("coc-concepts"))
  .settings(
    name := "coc-concepts"
  )

lazy val rules = (project in file("coc-rules"))
  .aggregate(concepts)
  .dependsOn(concepts)
  .settings(
    name := "coc-rules",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
