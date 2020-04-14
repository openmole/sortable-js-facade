import sbt.Keys._

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Sortable JS Facade"
normalizedName := "sortable-js-facade"
organization := "net.scalapro"

version := "0.3"

scalaVersion := "2.13.1"

crossScalaVersions := Seq("2.12.10", "2.13.1")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "1.0.0",
  "org.querki" %%% "querki-jsext" % "0.10"
)

pomExtra in Global := {
  <url>http://projects.scalapro.net/sortable-js-facade/</url>
    <licenses>
      <license>
        <name>MIT Licens</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/Kremlianski/sortable-js-facade.git</connection>
      <developerConnection>scm:git:git@github.com:Kremlianski/sortable-js-facade.git</developerConnection>
      <url>github.com/Kremlianski/sortable-js-facade.git</url>
    </scm>
    <developers>
      <developer>
        <id>alquimisto</id>
        <name>Alexandre Kremlianski</name>
        <url>http://scalapro.net/</url>
      </developer>
    </developers>
}
