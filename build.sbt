
name := "sparkQueryJob"

version := "0.1"

scalaVersion := "2.13.7"

val sparkVersion = "3.2.0"
val jenaVersion = "4.3.2"
val bellmanVersion = "1.2.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "com.github.gsk-aiops" % "bellman-spark-engine_2.12" % bellmanVersion,
  "org.apache.jena" % "jena-core" % jenaVersion,
  "org.apache.jena" % "jena-arq" % jenaVersion
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
