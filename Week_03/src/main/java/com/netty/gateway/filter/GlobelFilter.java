package com.netty.gateway.filter;


import com.netty.gateway.model.RequestContext;
import io.netty.channel.ChannelHandlerContext;

public interface GlobelFilter {

    boolean filter(RequestContext requestContext, FilterChain filterChain);
}
