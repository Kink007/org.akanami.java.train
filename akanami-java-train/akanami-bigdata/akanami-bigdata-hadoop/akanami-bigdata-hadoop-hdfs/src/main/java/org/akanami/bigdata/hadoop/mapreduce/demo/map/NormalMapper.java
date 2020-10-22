package org.akanami.bigdata.hadoop.mapreduce.demo.map;

import org.akanami.bigdata.hadoop.mapreduce.demo.model.LogBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class NormalMapper extends Mapper<LongWritable, Text, Text, LogBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] arr = StringUtils.split(line, "|");

        LogBean bean = new LogBean(arr[0], arr[1]);

        context.write(new Text(arr[0]), bean);
    }
}
