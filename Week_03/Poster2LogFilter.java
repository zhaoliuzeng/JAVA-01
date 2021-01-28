package java0.nio01.filter;

import io.netty.channel.ChannelHandlerContext;

public class Poster2LogFilter implements GlobelFilter {



    @Override
    public boolean filter(ChannelHandlerContext ctx, FilterChain filterChain) {
        filterChain.filter(ctx);
        System.out.println("poster");
        return true;
    }
}
