package org.akanami.nosql.redis.simple;

import org.akanami.nosql.redis.conf.GlobalConfiguration;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class StringDemo {
    public static void main(String[] args) {
        Jedis jedis = GlobalConfiguration.getJedis();
        Set<String> keys = jedis.keys("*");

        keys.forEach(s -> jedis.del(s));
    }
}
