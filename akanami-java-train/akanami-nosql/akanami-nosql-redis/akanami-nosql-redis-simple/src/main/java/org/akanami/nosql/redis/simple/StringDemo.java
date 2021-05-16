package org.akanami.nosql.redis.simple;

import org.akanami.nosql.redis.conf.RedisHelper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.Set;

public class StringDemo {
    public static void main(String[] args) {
        Jedis jedis = RedisHelper.getJedis();

        testRedisString(jedis);
        testRedisStringAsInt(jedis);
    }

    static void testRedisString(Jedis jedis) {
        String key = "sKey1";
        String value = "sValue1";

        String setResult = jedis.set(key, value);
        System.out.println("set result:" + setResult);

        String getValue = jedis.get(key);
        System.out.println("getValue:" + getValue + " equals: " + value.equals(getValue));

        try {
            Long incr = jedis.incr(key);
            System.out.println("after incr :" + incr);
        } catch (JedisDataException e) {
            e.printStackTrace();
        }
    }

    static void testRedisStringAsInt(Jedis jedis) {
        String key = "sIntKey1";
        Long incr = jedis.incr(key);
        System.out.println("redis incr init:" + incr);
        String s = jedis.get(key);
        System.out.println("redis incr getvalue:" + s + " equals long:" + s.equals(1) + " equals string:" + s.equals("1"));

        Long aLong = jedis.incrBy(key, 2);
        System.out.println("redis incrby 2:" + aLong);
        String s1 = jedis.get(key);
        System.out.println("redis incr getvalue:" + s1 + " equals long:" + s1.equals(3) + " equals string:" + s1.equals("3"));
    }
}
