package com.netty.gateway.inbound;

import com.netty.gateway.filter.FilterChain;
import com.netty.gateway.model.RequestContext;
import com.netty.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final String proxyServer;
    private HttpOutboundHandler handler;
    private final String routerStrategy;

    public HttpInboundHandler(String proxyServer, String routerStrategy) {
        this.proxyServer = proxyServer;
        this.routerStrategy = routerStrategy;
        handler = new HttpOutboundHandler(this.proxyServer, this.routerStrategy);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            //logger.info("channelRead流量接口请求开始，时间为{}", startTime);
            final FullHttpRequest fullRequest = (FullHttpRequest) msg;
            final FilterChain filterChain = new FilterChain(0);
            RequestContext requestContext = new RequestContext(handler, fullRequest, ctx);
            filterChain.filter(requestContext);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            ReferenceCountUtil.release(msg);
        }
    }
}
