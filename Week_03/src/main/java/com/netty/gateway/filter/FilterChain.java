package com.netty.gateway.filter;


import com.netty.gateway.model.RequestContext;

import java.util.ArrayList;
import java.util.List;


public class FilterChain {
    private static volatile boolean invoked = false;
    private List<GlobelFilter> filters = new ArrayList<>();
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

    public synchronized boolean filter(RequestContext requestContext) {
        if (this.index < filters.size()) {
            GlobelFilter filter = (GlobelFilter) filters.get(this.index);
            filter.filter(requestContext, new FilterChain((index + 1)));
        }

        if (!invoked) {
            invoked = true;
            requestContext.getHttpOutboundHandler().handle(requestContext.getFullRequest(), requestContext.getCtx());
        }
        return false;
    }
}
