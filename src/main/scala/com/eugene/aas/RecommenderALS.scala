package com.eugene.aas

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}

import scala.collection.Map

/**
  * Created by eugene on 16/3/18.
  */
object RecommenderALS {

    def main(args: Array[String]) {
        val conf = new SparkConf().setAppName("RecommenderALS").setMaster("local")
        val sc = new SparkContext(conf)

        val base = "/home/eugene/Downloads/profiledata_06_May_2005/"
        val rawUserArtistData = sc.textFile(base + "user_artist_data.txt")
        val rawArtistData = sc.textFile(base + "artist_data.txt")
        val rawArtistAlias = sc.textFile(base + "artist_alias.txt")
    }

    def buildArtistByID(rawArtistData: RDD[String]) = rawArtistData.flatMap {
        line =>
            val (id, name) = line.span(_ != '\t')
            if (name.isEmpty) None
            else {
                try {
                    Some((id.toInt, name.trim))
                } catch {
                    case e: NumberFormatException => None
                }
            }
        }

    def buildArtistAlias(rawArtistAlias: RDD[String]): Map[Int, Int] = rawArtistAlias.flatMap {
        line =>
            val tokens = line.split('\t')
            if (tokens(0).isEmpty) None
            else Some((tokens(0).toInt, tokens(1).toInt))
        }.collectAsMap()

}
