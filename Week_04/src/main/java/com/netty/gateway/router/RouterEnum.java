package com.netty.gateway.router;

import java.util.List;

public enum RouterEnum {
    LOADBALANCE("loadbalance") {
        @Override
        public String route(List<String> endpoints) {
            return endpoints.get(0);
        }
    }, RANDOM("random") {
        @Override
        public String route(List<String> endpoints) {
            return endpoints.get(0);
        }
    }, WEIGH("weigh") {
        @Override
        public String route(List<String> endpoints) {
            return endpoints.get(0);
        }
    }, ROUNDRIBBON("roundribbon") {
        @Override
        public String route(List<String> endpoints) {
            return endpoints.get(0);
        }
    };
    private String name;

    RouterEnum(String name) {
        this.name = name;
    }

    public static RouterEnum getEnum(String name){
        for(RouterEnum item : values()){
            if(item.name.equalsIgnoreCase(name))
                return item;
        }
        return null;
    }

    public abstract String route(List<String> endpoints);
}
