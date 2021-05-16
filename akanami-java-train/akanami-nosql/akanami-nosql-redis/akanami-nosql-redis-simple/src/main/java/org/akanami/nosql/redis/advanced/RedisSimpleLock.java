package org.akanami.nosql.redis.advanced;

import org.akanami.nosql.redis.conf.RedisHelper;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.UUID;

public class RedisSimpleLock {
    public static void main(String[] args) {
        Jedis jedis = RedisHelper.getJedis();

        testTime();
    }

    static void testTime() {
        long now = System.currentTimeMillis();
        long end = now + 1000;
        System.out.println("begin:" + now + " end:" + end);

        try {
            Thread.sleep(99);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("now:" + System.currentTimeMillis());
    }

    static void testLock(Jedis jedis) {
        boolean b = acquireLock(jedis);
        if(b) {
            //jedis.multi();
            //jedis.sendCommand()
        }
    }

    static boolean acquireLock(Jedis jedis) {
        String uuid = UUID.randomUUID().toString();
        String lockKey = "lock_test_1";

        final long interval = 2000;
        long now= System.currentTimeMillis();
        long timeout = now + interval;

        while (System.currentTimeMillis() < timeout ) {
            if(jedis.setnx(lockKey, uuid) > 0) {
                return true;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    static void acquireLock(String key) {

    }

}
