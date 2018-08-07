package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <br>
 * <br>Darian
 **/
public class 复制不同的值_创建一个子列表_9 {

    public static void main(String[] args) {
        end();
    }

    public static void end() {
        // 用所有不同的数字创建一个正方形列表
        // 本例展示了如何利用流的 distinct() 方法来对集合进行去重。
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers
                .stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
}
