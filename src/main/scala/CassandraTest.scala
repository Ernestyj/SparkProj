import java.util.Date

import com.datastax.driver.core.ResultSet
import com.datastax.spark.connector.cql.CassandraConnector
import org.apache.spark.{SparkConf, SparkContext}
import com.datastax.spark.connector._

/**
  * Created by eugene on 16/3/16.
  */
object CassandraTest {
    def main(args: Array[String]) {
        val conf = new SparkConf(true).
//            set("spark.cassandra.connection.host", "192.168.1.106").
//            set("spark.cassandra.connection.host", "202.120.40.111")
//            set("spark.cassandra.connection.host", "121.41.126.207")
            set("spark.cassandra.connection.host", "10.253.26.54")
        val sc = new SparkContext("local", "test", conf)

//        val conn = CassandraConnector(conf)
//        conn.withSessionDo{ session =>
////            var result = session.execute("select * from stock_market.stock_day_open")
//            var result = session.execute("select * from market_quotation.stock_day_open")
//            println(result.one())
//        }
        val tableRDD = sc.cassandraTable[CassandraRow]("market_quotation", "stock_day_open")
        val stock = tableRDD.where("stock=?", "000001.SZ")
        stock.foreach(col => println(col.get[String]("day").toString+" "+col.get[Float]("open")))

//        val collection = sc.parallelize(Seq(("key3", 3), ("key4", 4)))
//        collection.saveToCassandra("test", "kv", SomeColumns("key", "value"))

        System.exit(0)
    }
}
