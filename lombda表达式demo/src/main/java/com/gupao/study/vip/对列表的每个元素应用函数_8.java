package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <br>
 * <br>Darian
 **/
public class 对列表的每个元素应用函数_8 {

    public static void main(String[] args) {
        end();
    }

    public static void end() {
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7Countries);
        List<String> collect = G7.stream()
                .map(x -> x.toLowerCase())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
