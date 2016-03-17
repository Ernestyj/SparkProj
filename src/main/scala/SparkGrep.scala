
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

/**
  * Created by eugene on 16/3/15.
  */
object SparkGrep {
    def main(args: Array[String]) {
        val conf = new SparkConf().setAppName("SparkGrep").setMaster("local")
        val sc = new SparkContext(conf)
        val inputFile = sc.textFile("src/main/scala/SparkGrep.scala", 2).cache()
        val matchTerm : String = "val"
        val numMatches = inputFile.filter(line => line.contains(matchTerm)).count()
        println("%s lines in %s contain %s".format(numMatches, args(1), matchTerm))
        System.exit(0)
    }
}
