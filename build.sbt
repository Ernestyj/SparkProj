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

