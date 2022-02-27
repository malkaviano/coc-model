import Dependencies._

ThisBuild / scalaVersion := "2.13.8"
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
  .dependsOn(concepts)
  .aggregate(fundamentals)
  .dependsOn(fundamentals)
  .aggregate(behaviors)
  .dependsOn(behaviors)
  .aggregate(helpers)
  .dependsOn(helpers)
  .aggregate(foundations)
  .dependsOn(foundations)
  .settings(
    name := "coc-model",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

lazy val concepts = (project in file("coc-concepts"))
  .settings(
    name := "coc-concepts",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )

lazy val behaviors = (project in file("coc-behaviors"))
  .aggregate(concepts)
  .dependsOn(concepts)
  .settings(
    name := "coc-behaviors",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

lazy val fundamentals = (project in file("coc-fundamentals"))
  .aggregate(concepts)
  .dependsOn(concepts)
  .aggregate(behaviors)
  .dependsOn(behaviors % "compile->compile;test->test")
  .settings(
    name := "coc-fundamentals",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

lazy val helpers = (project in file("coc-helpers"))
  .aggregate(concepts)
  .dependsOn(concepts)
  .aggregate(behaviors)
  .dependsOn(behaviors % "compile->compile;test->test")
  .aggregate(fundamentals)
  .dependsOn(fundamentals)
  .settings(
    name := "coc-helpers",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

lazy val foundations = (project in file("coc-foundations"))
  .aggregate(concepts)
  .dependsOn(concepts)
  .aggregate(behaviors)
  .dependsOn(behaviors % "compile->compile;test->test")
  .aggregate(fundamentals)
  .dependsOn(fundamentals)
  .aggregate(helpers)
  .dependsOn(helpers)
  .settings(
    name := "coc-foundations",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      scalaTestPlus % Test,
      scalaMock % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
