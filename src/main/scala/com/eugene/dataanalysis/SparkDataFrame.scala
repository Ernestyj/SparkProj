package com.eugene.dataanalysis

import java.sql.Timestamp

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import com.databricks.spark.csv._
import org.joda.time.format.DateTimeFormat

/**
  * Created by eugene on 16/3/30.
  */
object SparkDataFrame {
    def main(args: Array[String]) {
        val conf = new SparkConf().setAppName("csvDataFrame").setMaster("local")
        val sc = new SparkContext(conf)
        val sqlContext = new SQLContext(sc)

        val stock = sqlContext.csvFile(filePath = "src/main/resources/wsd_000001.SZ_2015.csv",
            useHeader = true, delimiter = '\t')
//        stock.printSchema()
//        stock.show()
//        stock.take(5).foreach(println)
//        val ohlc = stock.select("OPEN","HIGH","LOW","CLOSE")
//        ohlc.show(10)
//        stock.filter("OPEN>15").show(8)
//        stock.filter("SUSP_REASON='' OR SUSP_REASON='NULL'").show(8)
//        stock.sort(stock("OPEN").desc).show()   //as String sort, neet to cast to Integer

        stock.registerTempTable("stock")
//        val dfFilteredBySQL = sqlContext.sql("select * from stock where OPEN>15")
//        dfFilteredBySQL.show(8)

        val stock2 = sqlContext.csvFile(filePath = "src/main/resources/wsd_000001.SZ_2014.csv",
            useHeader = true, delimiter = '\t')
        val stock14_15 = stock.unionAll(stock2)
//        println(stock14_15.count())
        val castedCols = stock14_15.selectExpr("cast(OPEN as int) as Open",
            "HIGH", "LOW", "CLOSE")
        val sortedCols = castedCols.sort(castedCols("Open").desc)//castedCols.sort("Open")
        sortedCols.show(20)

        val formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
        val dateEx = "2014-01-02"
        val date = new Timestamp(formatter.parseDateTime(dateEx).getMillis)

    }
}
