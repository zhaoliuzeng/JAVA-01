package com.netty.gateway.filter;


import com.netty.gateway.model.RequestContext;
import io.netty.channel.ChannelHandlerContext;

public class PreLogFilter implements GlobelFilter {

    @Override
    public boolean filter(RequestContext requestContext , FilterChain filterChain) {
        System.out.println("pre");
        filterChain.filter(requestContext);

        return true;
    }
}
