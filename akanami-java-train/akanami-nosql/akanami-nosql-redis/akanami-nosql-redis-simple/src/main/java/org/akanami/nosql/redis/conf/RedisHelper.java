package org.akanami.nosql.redis.conf;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisHelper {
    private static String address = "120.78.145.202";
    private static Jedis instance;

    public static String getAddress() {
        return address;
    }

    public static Jedis getJedis() {
        if(instance == null) {
            instance = new Jedis(getAddress());
            instance.auth("Vis123ual");

            clear(instance);
        }

        return instance;
    }

    private static void clear(Jedis jedis) {
        Set<String> keys = jedis.keys("*");
        keys.forEach(t -> jedis.del(t));
    }
}
