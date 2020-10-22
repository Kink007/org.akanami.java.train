package org.akanami.bigdata.hadoop.mapreduce.demo;

import org.akanami.bigdata.hadoop.mapreduce.demo.map.NormalMapper;
import org.akanami.bigdata.hadoop.mapreduce.demo.model.LogBean;
import org.akanami.bigdata.hadoop.mapreduce.demo.reduce.NormalReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;

public class Demo01 extends Configured implements Tool {
    static {
        System.setProperty("HADOOP_USER_NAME", "hadoop");
    }

    public int run(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://49.234.38.24:9000");
        conf.set("dfs.client.use.datanode.hostname", "true");

        Job job = Job.getInstance(conf);
        job.setJarByClass(Demo01.class);
        job.setMapperClass(NormalMapper.class);
        job.setReducerClass(NormalReduce.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LogBean.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LogBean.class);

        System.out.println(args);
        //给定输入
        FileInputFormat.setInputPaths(job,new Path("/demo01/hello.txt"));
        //给定输出
        FileOutputFormat.setOutputPath(job, new Path("/demo01/output/out"));

        return job.waitForCompletion(true)?0:1;
    }

    public static void main(String[] args) {
        try {
            int run = new Demo01().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
