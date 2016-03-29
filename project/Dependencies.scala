import sbt._

object Dependencies {
    // Versions
    lazy val sparkVersion = "1.6.0"
    lazy val sparkCassConnVersion = "1.5.0"
    // Libraries
    val sparkCore = "org.apache.spark" % "spark-core_2.10" % sparkVersion //2.10.6部分获取失败
    val sparkSQL = "org.apache.spark" % "spark-sql_2.10" % sparkVersion
    val sparkMLLib = "org.apache.spark" % "spark-mllib_2.10" % sparkVersion

    val sparkCassandraConnector = "com.datastax.spark" % "spark-cassandra-connector_2.10" % sparkCassConnVersion
//    val sparkCassandraConnectorEmbedded = "com.datastax.spark" % "spark-cassandra-connector-embedded_2.10" % sparkCassConnVersion
    // Projects
    val rootDependencies = Seq(sparkCore, sparkSQL, sparkMLLib,
        sparkCassandraConnector)

}
