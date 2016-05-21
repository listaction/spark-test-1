package utils

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SQLContext

object SparkSQL {

  def simpleSparkSQLApp {    
    val driverHost = "localhost"
    val conf = new SparkConf(false) // skip loading external settings
      .setMaster("local[4]") // run locally with enough threads
      .setAppName("firstSparkApp")
      .set("spark.logConf", "true")
      .set("spark.driver.host", s"$driverHost")
    val sc = new SparkContext(conf)
    
    val sqlContext = new SQLContext(sc)
    
    import sqlContext._
    val path = "ecommerce-event-data.json"
    val returnType = sqlContext.read.json(path)

    returnType.select("user_name").collect().foreach { x => println(x.getString(0)) }
    returnType.printSchema();
    
    
  }

}