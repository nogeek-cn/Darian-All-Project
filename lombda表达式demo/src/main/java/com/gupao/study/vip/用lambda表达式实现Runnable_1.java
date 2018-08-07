package com.gupao.study.vip;

/**
 * <br>
 * <br>Darian
 **/
public class 用lambda表达式实现Runnable_1 {
    public static void main(String[] args) {
        //beforeJAVA8();
        //Java8();
    }

    public static void before() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before Java8, too much code");
            }
        }).start();
    }

    public static void end() {
        new Thread(() -> System.out.println("In Java8")).start();
    }

}
