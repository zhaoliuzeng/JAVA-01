package com.confuration.config;

import java.util.List;

public class RpcFxConfig {
    private Integer port;
    private String host;
    private List<String> interfaceName;


    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public List<String> getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(List<String> interfaceName) {
        this.interfaceName = interfaceName;
    }
}
