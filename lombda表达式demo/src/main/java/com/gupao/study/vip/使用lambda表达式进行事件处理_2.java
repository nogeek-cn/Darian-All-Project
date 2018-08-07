package com.gupao.study.vip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <br>
 * <br>Darian
 **/
public class 使用lambda表达式进行事件处理_2 {

    public static void main(String[] args) {
        before();
        // lambda8();
    }

    public static void before(){
        JButton show  = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("before");
            }
        });
    }

    public static void end(){
        JButton show = new JButton("show");
        show.addActionListener((e)-> System.out.println("lambda"));
    }
}
