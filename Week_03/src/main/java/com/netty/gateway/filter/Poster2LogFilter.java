package com.netty.gateway.filter;

import com.netty.gateway.model.RequestContext;
import io.netty.channel.ChannelHandlerContext;

public class Poster2LogFilter implements GlobelFilter {



    @Override
    public boolean filter(RequestContext requestContext, FilterChain filterChain) {
        filterChain.filter(requestContext);
        System.out.println("poster");
        return true;
    }
}
