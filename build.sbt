import bintray.Keys._

sbtPlugin := true

//organization := "com.typesafe.sbt" someday perhaps

organization := "pl.project13.scala"

name := "sbt-jmh"

version := "0.1.5"

val jmhVersion = "0.9.2"

libraryDependencies += "org.openjdk.jmh" % "jmh-core"                 % jmhVersion    // GPLv2

libraryDependencies += "org.openjdk.jmh" % "jmh-generator-bytecode"   % jmhVersion    // GPLv2

libraryDependencies += "org.openjdk.jmh" % "jmh-generator-reflection" % jmhVersion    // GPLv2

libraryDependencies += "org.openjdk.jmh" % "jmh-generator-asm"        % jmhVersion    // GPLv2

publishTo <<= isSnapshot { snapshot =>
  if (snapshot) Some(Classpaths.sbtPluginSnapshots) else Some(Classpaths.sbtPluginReleases)
}


// publishing settings

publishMavenStyle := false

bintrayPublishSettings

repository in bintray := "sbt-plugins"

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

bintrayOrganization in bintray := None
