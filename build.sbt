import java.io.File

import Dependencies._

lazy val commonSettings = Seq(
    name := "SparkStudy",
    organization := "com.eugene",
    version := "0.1.0",
    scalaVersion := "2.10.6")

lazy val root = (project in file(".")).
        settings(commonSettings: _*).
        settings(libraryDependencies ++= rootDependencies).
        settings(resolvers ++= rootResolvers)



//For assembly
assemblyMergeStrategy in assembly := {
    case str if str.startsWith("META-INF") => MergeStrategy.first
//    case PathList("org", "slf4j", xs @ _*)         => MergeStrategy.first
//    case PathList("org", "codehaus", xs @ _*)         => MergeStrategy.first
//    case PathList("com", "esotericsoftware", xs @ _*)         => MergeStrategy.first
//    case PathList(ps @ _*) if ps.last endsWith "axiom.xml" => MergeStrategy.filterDistinctLines
//    case PathList(ps @ _*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.first
//    case PathList(ps @ _*) if ps.last endsWith "ILoggerFactory.class" => MergeStrategy.first
//    case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
//    case PathList("javax", "activation", xs @ _*) => MergeStrategy.first
//    case PathList("org", "apache", xs @ _*) => MergeStrategy.first
//    case PathList("com", "google", xs @ _*) => MergeStrategy.first
//    case PathList("io", "netty", xs @ _*) => MergeStrategy.first
//    case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.first
//    case PathList("commons-beanutils", xs @ _*) => MergeStrategy.first
//    case PathList("commons-collections", xs @ _*) => MergeStrategy.first
//    case PathList("javax", "xml", xs @ _*) => MergeStrategy.first
//    case PathList("com", "codahale", xs @ _*) => MergeStrategy.first
//    case PathList("com", "yammer", xs @ _*) => MergeStrategy.first
//    case "about.html" => MergeStrategy.rename
//    case "plugin.properties" => MergeStrategy.first
//    case "log4j.properties" => MergeStrategy.first
//    case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
//    case "application.conf"                            => MergeStrategy.concat
//    case "unwanted.txt"                                => MergeStrategy.discard
    case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
}
