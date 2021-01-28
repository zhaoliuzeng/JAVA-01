package java0.nio01.filter;

import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;


public class FilterChain {
    private static volatile boolean invoked = false;
    private List<GlobelFilter> filters = new ArrayList<>();
    private static HttpInvoke invoke = new HttpInvoke();
    private int index;

    {
        filters.add(new PosterLogFilter());
        filters.add(new Poster2LogFilter());
        filters.add(new PreLog2Filter());
        filters.add(new PreLogFilter());
    }

    public FilterChain(int index) {
        this.index = index;
    }

    public synchronized boolean filter(ChannelHandlerContext ctx) {
        if (this.index < filters.size()) {
            GlobelFilter filter = (GlobelFilter) filters.get(this.index);
            filter.filter(ctx, new FilterChain((index + 1)));
        }

        if (!invoked) {
            invoked = true;
            System.out.println(invoke.invoke());
        }
        return false;
    }
}
