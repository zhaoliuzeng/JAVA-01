package com.netty.gateway.model;

import com.netty.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class RequestContext {
    private final HttpOutboundHandler httpOutboundHandler;
    private final FullHttpRequest fullRequest;
    private final ChannelHandlerContext ctx;

    public RequestContext(HttpOutboundHandler httpOutboundHandler, FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        this.httpOutboundHandler = httpOutboundHandler;
        this.fullRequest = fullRequest;
        this.ctx = ctx;
    }

    public HttpOutboundHandler getHttpOutboundHandler() {
        return httpOutboundHandler;
    }


    public FullHttpRequest getFullRequest() {
        return fullRequest;
    }


    public ChannelHandlerContext getCtx() {
        return ctx;
    }


}
