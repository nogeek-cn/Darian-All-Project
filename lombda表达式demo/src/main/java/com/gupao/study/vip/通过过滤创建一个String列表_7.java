package com.gupao.study.vip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <br>
 * <br>Darian
 **/
public class 通过过滤创建一个String列表_7 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "bcd", "defg", "jk");
        end(stringList);
    }

    public static void end(List<String> stringList) {

        List<String> filtered =
                stringList.stream()
                        .filter(x -> (x.length() > 2))
                        .collect(Collectors.toList());

        System.out.printf("org List: %s,fitter List:%s%n", stringList, filtered);

    }
}
