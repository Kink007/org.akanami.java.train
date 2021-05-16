package org.akanami.nosql.redis.simple;

import org.akanami.nosql.redis.conf.RedisHelper;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class HashDemo {
    public static void main(String[] args) {
        Jedis jedis = RedisHelper.getJedis();
        for(int i = 1; i < 10; i++) {

            HashMap<String, String> user = new HashMap<>();
            user.put("id", Integer.toString(i));
            user.put("name", "admin");

            jedis.hset("user:" + Integer.toString(i), user);

            jedis.expire("user:" + Integer.toString(i), 10);
        }
    }
}
