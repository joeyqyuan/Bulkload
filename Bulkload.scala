
#This works in spark-shell 2.0+
 val table = new HTable(conf, tableNameOut)
 conf.set(TableOutputFormat.OUTPUT_TABLE, tableNameOut)
 
 //valueRDD is a List[([ImmutableBytesWritable],[KeyValue])]
 valueRDD.saveAsNewAPIHadoopFile(outputPath, classOf[ImmutableBytesWritable], classOf[KeyValue], classOf[HFileOutputFormat], conf)
 
 val bulkLoader = new LoadIncrementalHFiles(conf)
 bulkLoader.doBulkLoad(new Path(outputPath), table)
 
 # spark-commit
