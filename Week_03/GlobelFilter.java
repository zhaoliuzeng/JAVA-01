package java0.nio01.filter;

import io.netty.channel.ChannelHandlerContext;

public interface GlobelFilter {

    boolean filter(ChannelHandlerContext ctx, FilterChain filterChain);
}
