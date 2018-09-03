package com.gupao.study.vip.demo;

import java.util.*;

/**
 * <br>
 * <br>Darian
 **/
public class ObserverDemo {

    public static void main(String[] args) {

        MyObservable observable = new MyObservable();

        // 增加订阅者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object value) {
                System.out.println(value);
            }
        });


        observable.setChanged();
        // 发布者通知，订阅者是被动感知（推动模式）
        observable.notifyObservers("hello, world");

        echoIterator();

    }

    private static void echoIterator() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        ListIterator<Integer> iterator = values.listIterator();
        while (iterator.hasNext()) {// 通过循环，主动去获取
            System.out.println(iterator.next());
        }
    }

    public static class MyObservable extends Observable {

        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }
}
