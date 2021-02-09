package com.netty.gateway.aop;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class Foo {
    @BindingPriority(3)
     String sayHelloFoo(){
        return "1";
    }
}
