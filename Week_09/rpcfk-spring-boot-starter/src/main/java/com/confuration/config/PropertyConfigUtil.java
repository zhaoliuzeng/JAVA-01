package com.confuration.config;

import java.util.Arrays;
import java.util.Properties;

public class PropertyConfigUtil {
    private static final RpcFxConfig rpcFxConfig = new RpcFxConfig();
    private static final String DEFAULT_PORT = "8090";
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static volatile boolean loadFlag = false;


    private static final String pre_fix = "rpcfx.";

    public static void loadData(Properties properties) {
        if (loadFlag == false) {
            synchronized (PropertyConfigUtil.class) {
                if (loadFlag == false) {
                    loadFlag = true;
                    rpcFxConfig.setPort(Integer.parseInt(properties.getProperty(pre_fix + "port", DEFAULT_PORT)));
                    rpcFxConfig.setHost(properties.getProperty(pre_fix + "port", DEFAULT_HOST));
                    rpcFxConfig.setInterfaceName(Arrays.asList(properties.getProperty(pre_fix + "interfaceName").split(",")));
                }
            }
        }
    }


    public static RpcFxConfig getRpcFxConfig() {
        return rpcFxConfig;
    }


}
