package main

import org.apache.spark.sql._
import com.gsk.kg.engine.syntax._
import org.apache.jena.riot.Lang

object SparkJob {
  def main(args: Array[String]) = {
    val spark = SparkSession.builder()
      .appName("SparkTestApp")
      .enableHiveSupport()
      .getOrCreate()
    org.apache.jena.query.ARQ.init()
    implicit val sqlcntx = spark.sqlContext
    val df = spark.read.option("sep", " ").csv("s3a://spark-data-552134/wdump-2023WithoutG.nt")
    val df2 = df.withColumnRenamed("_c3","g").withColumnRenamed("_c0","s").withColumnRenamed("_c1","p").withColumnRenamed("_c2","o")
    df2.sparql(""" SELECT ?s ?p ?o WHERE { ?s ?p ?o } """).show()
    spark.stop()
  }
}
