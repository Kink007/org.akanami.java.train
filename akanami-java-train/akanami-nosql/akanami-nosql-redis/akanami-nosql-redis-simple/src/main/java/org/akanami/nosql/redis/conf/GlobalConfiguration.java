package org.akanami.nosql.redis.conf;

import redis.clients.jedis.Jedis;

public class GlobalConfiguration {
    private static String address = "120.78.145.202";
    private static Jedis instance;

    public static String getAddress() {
        return address;
    }

    public static Jedis getJedis() {
        if(instance == null) {
            instance = new Jedis(getAddress());
        }

        return instance;
    }
}
