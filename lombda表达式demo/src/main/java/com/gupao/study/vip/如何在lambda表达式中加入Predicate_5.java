package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * <br>
 * <br>Darian
 **/
public class 如何在lambda表达式中加入Predicate_5 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Java","Jav","jjjj","aaaa");
        end(stringList);
    }

    public static void end(List<String> names){
        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is :     " + n));
    }
}
