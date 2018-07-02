package com.gupao.study.vip;

import java.io.IOException;

/**
 * <br>类说明 :
 * <br>属性说明：
 * <br>作者：Darian
 **/
public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Email email = new Email();
        email.setContent("今天去钓鱼");
        Person p1 = new Person("A");
        p1.setEmail(email);

        //Person p2 = p1.clone();
        Person p2 = p1.deepClone();
        p2.setName("B");
        p2.getEmail().setContent("今天去打架");


        System.out.println(p1);
        System.out.println(p2);



    }
}
