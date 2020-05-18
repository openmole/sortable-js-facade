import sbt.Keys._
import sbt._

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Sortable JS Facade"
normalizedName := "sortable-js-facade"
organization := "org.openmole"

version := "0.5"

scalaVersion := "2.13.2"

crossScalaVersions := Seq("2.12.11", "2.13.2")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "1.0.0",
  "org.querki" %%% "querki-jsext" % "0.10"
)

licenses := Seq("Affero GPLv3" -> url("http://www.gnu.org/licenses/"))
pomExtra in Global := {
  <url>http://projects.scalapro.net/sortable-js-facade/</url>
    <scm>
      <connection>scm:git:github.com/openmole/sortable-js-facade.git</connection>
      <developerConnection>scm:git:git@github.com:openmole/sortable-js-facade.git</developerConnection>
      <url>github.com/openmole/sortable-js-facade.git</url>
    </scm>
    <developers>
      <developer>
        <id>mathieu.leclaire</id>
        <name>Mathieu Leclaire</name>
      </developer>
    </developers>
}

releasePublishArtifactsAction := PgpKeys.publishSigned.value
releaseVersionBump := sbtrelease.Version.Bump.Minor
releaseTagComment := s"Releasing ${(version in ThisBuild).value}"
releaseCommitMessage := s"Bump version to ${(version in ThisBuild).value}"
sonatypeProfileName := organization.value
publishConfiguration := publishConfiguration.value.withOverwrite(true)

publishTo := sonatypePublishToBundle.value
publishMavenStyle := true
autoCompilerPlugins := true

import sbtrelease.ReleasePlugin.autoImport.ReleaseTransformations._

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  //setReleaseVersion,
  tagRelease,
  releaseStepCommand("publishSigned"),
  releaseStepCommand("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
