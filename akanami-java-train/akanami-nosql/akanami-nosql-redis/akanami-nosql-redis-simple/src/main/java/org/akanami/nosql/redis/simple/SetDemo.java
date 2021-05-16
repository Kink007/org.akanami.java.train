package org.akanami.nosql.redis.simple;

import org.akanami.nosql.redis.conf.RedisHelper;
import redis.clients.jedis.Jedis;

public class SetDemo {

    static final String sKey = "setKey";
    static final String sValue = "setValue";

    public static void main(String[] args) {
        Jedis jedis = RedisHelper.getJedis();

        testSet(jedis);
    }

    static void testSet(Jedis jedis) {
        Long sadd = jedis.sadd(sKey, sValue);
        System.out.println("sadd result:" + sadd);
        sadd = jedis.sadd(sKey, sValue);
        System.out.println("repeat sadd result:" + sadd);
        Boolean sismember = jedis.sismember(sKey, sValue);
        System.out.println("sismember:" + sismember);
        sismember = jedis.sismember(sKey, "");
        System.out.println("sismember with empty value:" + sismember);
    }
}
