package com.gupao.study.vip.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <br>
 * <br>Darian
 **/
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        // Annotation 驱动的 Spring 上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册监听器

        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent event) {
                System.out.println("接收到事件：" + event.getSource() + "\n@" + event.getApplicationContext());
            }
        });

        context.refresh();
        // 发布事件
        context.publishEvent(new MyApplicationEvent(context, "hello world!"));
        context.publishEvent(new MyApplicationEvent(context, 1));
        context.publishEvent(new MyApplicationEvent(context, new Integer(100)));
        // 监听器得到事件

    }


    private static class MyApplicationEvent extends ApplicationEvent {

        // 上下文
        private final ApplicationContext applicationContext;

        public MyApplicationEvent(ApplicationContext applicationContext, Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }
}
