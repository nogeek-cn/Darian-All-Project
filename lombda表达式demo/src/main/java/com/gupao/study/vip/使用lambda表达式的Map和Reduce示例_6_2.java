package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;

/**
 * <br>
 * <br>Darian
 **/
public class 使用lambda表达式的Map和Reduce示例_6_2 {

    public static void main(String[] args) {
        before();
        end();
    }

    public static void before() {
        // 为每个订单加上12%的税
        // 老方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            total = total + price;
        }
        System.out.println("Total : " + total);
    }

    public static void end() {
        // 新方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.
                stream()
                .map((cost) -> cost + .12 * cost)
                .reduce((sum, cost) -> sum + cost)
                .get();
        System.out.println("Total : " + bill);
    }
}
