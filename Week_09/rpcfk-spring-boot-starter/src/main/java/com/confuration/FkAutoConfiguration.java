package com.confuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

@ConditionalOnWebApplication
public class FkAutoConfiguration {

    @Bean
    public ServiceBeanDefinitionRegistry autoRegisteProxyBean() {
        return new ServiceBeanDefinitionRegistry();
    }
}