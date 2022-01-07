# sparkQueryJob
The spark job that runs SPARQL query on file from S3


To package
```bash
sbt assembly
```

Copy jar to S3. Copy jar from S3 to master node and run unsing:
```bash
aws s3 cp s3://{bucket-name}/sparkQueryJob-assembly-0.1.jar . 
```

Run job:
```bash
spark-submit ./sparkQueryJob-assembly-0.1.jar
```
