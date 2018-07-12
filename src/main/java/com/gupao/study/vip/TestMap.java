package com.gupao.study.vip;

import java.util.*;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class TestMap {

    public static void main(String[] args) {

        HashMap<String,Integer> map1 = new HashMap<>();

        map1.put("BB", new Integer(1));
        map1.put("Aa", new Integer(3));

        Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();

        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();

        while (it.hasNext()) {

            Map.Entry<String, Integer> entry = it.next();

            String key = entry.getKey();

            Integer value = entry.getValue();

            System.out.println(value);

        }

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Aa", new Integer(3));
        map2.put("BB", new Integer(1));


        Set<String> keySet2 = map2.keySet();

        for( String key :keySet2){
            System.out.println( map2.get(key) );
        }
    }

}
