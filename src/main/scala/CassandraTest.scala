import com.datastax.driver.core.ResultSet
import com.datastax.spark.connector.cql.CassandraConnector
import org.apache.spark.{SparkContext, SparkConf}
import com.datastax.spark.connector._

/**
  * Created by eugene on 16/3/16.
  */
object CassandraTest {
    def main(args: Array[String]) {
        val conf = new SparkConf(true).
//            set("spark.cassandra.connection.host", "192.168.1.106").
            set("spark.cassandra.connection.host", "202.120.40.111")
        val sc = new SparkContext("local", "test", conf)

        val conn = CassandraConnector(conf)
        conn.withSessionDo{ session =>
            var result = session.execute("select * from stock_market.stock_day_open")
            println(result.one())
        }
//        val rdd = sc.cassandraTable("stock_market", "stock_day_open")
//        val rdd = sc.cassandraTable("test", "kv")
//        println(rdd.count)
//        println(rdd.first)
//        println(rdd.map(_.getInt("value")).sum)

//        val collection = sc.parallelize(Seq(("key3", 3), ("key4", 4)))
//        collection.saveToCassandra("test", "kv", SomeColumns("key", "value"))

        System.exit(0)
    }
}
