package com.netty.gateway.model;

import com.netty.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.concurrent.atomic.AtomicBoolean;

public class RequestContext {
    private final HttpOutboundHandler httpOutboundHandler;
    private final FullHttpRequest fullRequest;
    private final ChannelHandlerContext ctx;
    private AtomicBoolean invokeCount = new AtomicBoolean(false);


    public RequestContext(HttpOutboundHandler httpOutboundHandler, FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        this.httpOutboundHandler = httpOutboundHandler;
        this.fullRequest = fullRequest;
        this.ctx = ctx;
    }

    public AtomicBoolean getInvokeCount() {
        return invokeCount;
    }

    public void setInvokeCount(AtomicBoolean invokeCount) {
        this.invokeCount = invokeCount;
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
