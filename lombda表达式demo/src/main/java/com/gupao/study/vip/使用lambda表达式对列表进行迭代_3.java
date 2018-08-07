package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;

/**
 * <br>
 * <br>Darian
 **/
public class 使用lambda表达式对列表进行迭代_3 {

    public static void main(String[] args) {
        // before();
        end();
    }

    public static void before(){
        List<String> stringList = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

        for (String string :stringList){
            System.out.println(string);
        }
    }

    public static void end(){
        List<String> stringList = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        stringList.forEach(string -> System.out.println(string));
    }
}
