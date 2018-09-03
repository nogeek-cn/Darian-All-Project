package com.gupao.study.vip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <br>
 * <br>Darian
 **/
@SpringBootApplication
public class SpringCloudConfigClassApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(SpringCloudConfigClassApplication.class);
        springApplication.setWebEnvironment(true);
        springApplication.run(args);

//        SpringApplication.run(SpringCloudConfigClassApplication.class,args);
    }
}
