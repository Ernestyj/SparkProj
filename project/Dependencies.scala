import sbt._

object Dependencies {
    // Versions
    lazy val sparkVersion = "1.6.0"
    lazy val sparkCassConnVersion = "1.5.0"
    lazy val breezeVersion = "0.12"
    // Libraries
    val sparkCore = "org.apache.spark" % "spark-core_2.10" % sparkVersion //2.10.6部分获取失败
    val sparkSQL = "org.apache.spark" % "spark-sql_2.10" % sparkVersion
    val sparkMLLib = "org.apache.spark" % "spark-mllib_2.10" % sparkVersion

    val sparkCSV = "com.databricks" % "spark-csv_2.10" % "1.4.0"

    val sparkCassandraConnector = "com.datastax.spark" % "spark-cassandra-connector_2.10" % sparkCassConnVersion
    //val sparkCassandraConnectorEmbedded = "com.datastax.spark" % "spark-cassandra-connector-embedded_2.10" % sparkCassConnVersion

    val breeze = "org.scalanlp" % "breeze_2.10" % breezeVersion
    val breezeNative = "org.scalanlp" % "breeze-natives_2.10" % breezeVersion
    val breezeViz = "org.scalanlp" % "breeze-viz_2.10" % breezeVersion

    val bokehScala = "io.continuum.bokeh" % "bokeh_2.10" % "0.6"
    val bokehScala_5 = "io.continuum.bokeh" % "bokeh_2.10" % "0.5"
    // Projects
    val rootDependencies = Seq(sparkCore, sparkSQL, sparkMLLib,
        sparkCSV,
        sparkCassandraConnector,
        breeze, breezeNative, breezeViz,
        bokehScala_5)

    val rootResolvers = Seq(
        // if you want to use snapshot builds (currently 0.12-SNAPSHOT), use this.
//        "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
        "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
    )
}
