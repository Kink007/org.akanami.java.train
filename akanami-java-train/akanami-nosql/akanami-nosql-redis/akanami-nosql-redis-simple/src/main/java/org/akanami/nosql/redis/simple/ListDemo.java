package org.akanami.nosql.redis.simple;

import org.akanami.nosql.redis.conf.RedisHelper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        Jedis jedis = RedisHelper.getJedis();

        testRedisListPushAndGet(jedis);
    }

    static void testRedisListPushAndGet(Jedis jedis) {
        String key = "lkey";
        String last = "last";
        String first = "first";

        jedis.lpush(key, first);
        List<String> lrange = jedis.lrange(key, 0, -1);
        System.out.println("lrange after push:" + lrange);
        String lpop = jedis.lpop(key);
        System.out.println("push first and lpop:" + lpop);
         lrange = jedis.lrange(key, 0, -1);
        System.out.println("lrange after pop:" + lrange);
    }
}
