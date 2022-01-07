# sparkQueryJob
The spark job that runs SPARQL query on file from S3


To package
```sbt assembly```

Copy jar to S3. Copy jar from S3 to master note and run unsing
```spark-submit ./sparkQueryJob-assembly-0.1.jar```
