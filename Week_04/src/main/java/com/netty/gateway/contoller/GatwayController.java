package com.netty.gateway.contoller;

import com.demo.starter.service.DemoService;
import gatway.auto.GatewayConfig;
import gatway.auto.NettyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GatwayController {

    @Autowired
    private GatewayConfig gatewayConfig;

    @Resource(name = "nettyService")
    private NettyService nettyService;
    @Resource(name = "demo")
    private DemoService demoService;


    @RequestMapping("hello")
    public String hello() {
        System.out.println(demoService.say());
        System.out.println(nettyService.getName());
        return gatewayConfig.getRouterName();

    }
}
