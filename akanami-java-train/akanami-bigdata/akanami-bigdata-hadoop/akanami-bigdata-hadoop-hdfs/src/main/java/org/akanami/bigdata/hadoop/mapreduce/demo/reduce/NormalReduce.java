package org.akanami.bigdata.hadoop.mapreduce.demo.reduce;

import org.akanami.bigdata.hadoop.mapreduce.demo.model.LogBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class NormalReduce extends Reducer<Text, LogBean, Text, LogBean> {
    @Override
    protected void reduce(Text key, Iterable<LogBean> values, Context context) throws IOException, InterruptedException {
        String name = "";
        String phone = "";

        for(LogBean bean : values) {
            name += ":" + bean.getName();
            phone += ":" + bean.getPhone();
        }

        context.write(key, new LogBean(name, phone));
    }
}
