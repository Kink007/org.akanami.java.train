package org.akanami.bigdata.hadoop.hdfs.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class demo01 {
    static  {
        System.setProperty("HADOOP_USER_NAME", "hadoop");
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        //conf.set("fs.defaultFS", "hdfs://49.234.38.24:9000");
        conf.set("fs.defaultFS", "hdfs://49.234.38.24:9000");
        //使用docker时，必填项
        //并在本地etc/host添加  datanode的hostname的ip映射
        conf.set("dfs.client.use.datanode.hostname", "true");

        byte[] buff = "hello|world".getBytes();
        FileSystem hdfs = FileSystem.get(conf);
        Path path = new Path("/demo01/hello.txt");
        FSDataOutputStream outputStream = null;

        try {
            outputStream = hdfs.create(path);
            outputStream.write(buff, 0, buff.length);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            if(outputStream != null)
                outputStream.close();
        }

        FileStatus files[] = hdfs.listStatus(path);
        for(FileStatus file : files) {
            System.out.println(file.getPath());
        }

        System.out.println("finished");
    }
}
