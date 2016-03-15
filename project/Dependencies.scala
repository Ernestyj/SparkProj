import sbt._

object Dependencies {
    // Versions
//    lazy val akkaVersion = "2.3.8"
    // Libraries
//    val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
//    val specs2core = "org.specs2" %% "specs2-core" % "2.4.14"
    val sparkCore= "org.apache.spark" % "spark-core_2.10" % "1.6.0" //2.10.6部分获取失败
    // Projects
//    val backendDeps = Seq(akkaActor, specs2core % Test)
    val rootDependencies = Seq(sparkCore)
}
