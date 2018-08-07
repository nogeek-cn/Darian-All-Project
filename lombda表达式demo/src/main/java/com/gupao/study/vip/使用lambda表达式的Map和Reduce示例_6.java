package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;

/**
 * <br>
 * <br>Darian
 **/
public class 使用lambda表达式的Map和Reduce示例_6 {

    public static void main(String[] args) {
        before();
        System.out.println();
        end();
    }

    public static void before() {
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }
    }

    public static void end(){
        // 使用lambda表达式
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax
                .stream()
                .map((cost) -> cost + .12*cost)
                .forEach(System.out::println);
    }
}
