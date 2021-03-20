package com.louie.week;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Import(ModelClass.class)
@SpringBootApplication
@EnableAspectJAutoProxy
//@EnableJms    //启动消息队列
//@EnableMongoRepositories

public class Springboot01Application {

    public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(Springboot01Application.class, args);

        ApplicationContext ctx = SpringApplication.run(Springboot01Application.class, args);
        //所有的bean,参考：http://412887952-qq-com.iteye.com/blog/2314051
        String[] beanNames = ctx.getBeanDefinitionNames();
        //String[] beanNames = ctx.getBeanNamesForAnnotation(RestController.class);//所有添加该注解的bean

        Thread.sleep(5000);

        System.out.println(123);

        for (String s : beanNames) {
            System.out.println(s);
        }
    }


    @Bean("testBean")
    public String getBean() {
        return "123";
    }


}
