package java0.nio01.filter;

import io.netty.channel.ChannelHandlerContext;

public class PreLog2Filter implements GlobelFilter {

    @Override
    public boolean filter(ChannelHandlerContext ctx , FilterChain filterChain) {
        System.out.println("pre");
        filterChain.filter(ctx);

        return true;
    }
}
