package gatway.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

import java.util.List;

@ConfigurationProperties(prefix = "com.netty")
public class GatewayConfig {
    private String routerName;
    private List<String> enableFilters;
    private List<String> backendServices;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public List<String> getEnableFilters() {
        return enableFilters;
    }

    public void setEnableFilters(List<String> enableFilters) {
        this.enableFilters = enableFilters;
    }

    public List<String> getBackendServices() {
        return backendServices;
    }

    public void setBackendServices(List<String> backendServices) {
        this.backendServices = backendServices;
    }
}
