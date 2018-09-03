package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;

/**
 * <br>
 * <br>Darian
 **/
public class 数组集合相互转化 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 2, 23, 3);
        System.out.println(integerList.toString());

        Integer[] integers = integerList.toArray(new Integer[integerList.size()]);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
