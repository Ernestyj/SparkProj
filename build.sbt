import Dependencies._

lazy val commonSettings = Seq(
    name := "SparkStudy",
    organization := "com.eugene",
    version := "0.1.0",
    scalaVersion := "2.10.6")

lazy val root = (project in file(".")).
        settings(commonSettings: _*).
        settings(
            libraryDependencies ++= rootDependencies
        )

assemblyMergeStrategy in assembly := {
    case _ => MergeStrategy.deduplicate
//    case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
//    case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
//    case "application.conf"                            => MergeStrategy.concat
//    case "unwanted.txt"                                => MergeStrategy.discard
//    case x =>
//        val oldStrategy = (assemblyMergeStrategy in assembly).value
//        oldStrategy(x)
}
