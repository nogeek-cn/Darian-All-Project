package com.gupao.study.vip;

import javax.sql.rowset.Predicate;
import java.util.Arrays;
import java.util.List;

/**
 * <br>
 * <br>Darian
 **/
public class 使用lambda表达式和函数式接口Predicate_4 {

//
//    public static void before() {
//        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//
//        System.out.println("Languages which starts with J :");
//        filter(languages, (str) -> str.startsWith("J"));
//
//        System.out.println("Languages which ends with a ");
//        filter(languages, (str) -> str.endsWith("a"));
//
//        System.out.println("Print all languages :");
//        filter(languages, (str) -> true);
//
//        System.out.println("Print no language : ");
//        filter(languages, (str) -> false);
//
//        System.out.println("Print language whose length greater than 4:");
//        filter(languages, (str) -> str.length() > 4);
//
//    }
//
//    public static void filter(List<String> names, Predicate condition) {
//         for (String name : names) {
//            if (condition.test(name)) {
//                System.out.println(name + " ");
//            }
//        }
//    }
//
//    public static void end(List names, Predicate condition){
//        names.stream().filter((name)->(condition.test(name))).forEach((name) -> {
//            System.out.println(name + " ");
//        });
//    }
}
