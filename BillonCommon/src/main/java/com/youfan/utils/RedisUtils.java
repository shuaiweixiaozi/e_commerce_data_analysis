package com.youfan.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class RedisUtils {
    public static final Jedis jedis = new Jedis("192.168.159.131",6379);

    public  static String getBykey (String key){
        return jedis.get(key);
    }

    public  static String setBykey (String key,String value){
        return jedis.set(key,value);
    }

    public static void addScoreData(String topName,double score,String key){
        jedis.zadd(topName,score,key);
    }

    public static void incrScoreData(String topName,double incrscore,String key){
        jedis.zincrby(topName,incrscore,key);
    }

    public static Set<String>  getTopData(String topName,long topNum){
        Set<String> set = jedis.zrevrange(topName,0,topNum-1);
        return set;
    }

    public static Set<Tuple>  getTopDataByScore(String topName,long topNum){
        Set<Tuple> setByscore = jedis.zrevrangeWithScores(topName,0,topNum-1);
        return setByscore;
    }

    public static void main(String[] args) {
        setBykey("test2","test22");
        String value = jedis.get("test2");
        jedis.zadd("ceshi1",45,"user1");
        jedis.zadd("ceshi1",56,"user2");
        jedis.zadd("ceshi1",16,"user3");
        jedis.zincrby("ceshi1",50,"user3");
        Set<String> set = jedis.zrevrange("ceshi1",0,1);
        for(String temp:set){
            System.out.println(temp);
        }

        Set<Tuple> setByscore = jedis.zrevrangeByScoreWithScores("ceshi1",1000,0);
        for(Tuple tuple :setByscore){
            String element = tuple.getElement();
            double score = tuple.getScore();
            System.out.println(element+":"+score);

        }
        //        System.out.println(value);
    }
}
