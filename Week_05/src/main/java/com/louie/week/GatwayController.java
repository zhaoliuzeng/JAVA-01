package com.louie.week;

import com.demo.starter.service.DemoService;
import com.louie.week.myannotation.MyCache;
import gatway.auto.GatewayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.time.Duration;
import java.util.Random;

@RestController
@MyCache
public class GatwayController {
    @Resource(name = "demo")
    private DemoService demoService;

    @Autowired
    private GatewayConfig gatewayConfig;


    @RequestMapping("hello")
    @MyCache
    @Cacheable
    public String hello() {
        return demoService.say() + gatewayConfig.getName()+new Random().nextInt(10000000);
    }
}
