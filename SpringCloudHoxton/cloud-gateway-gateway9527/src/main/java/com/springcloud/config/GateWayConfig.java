package com.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lizz
 * @date 2020/3/15 20:24
 */
@Component
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes().route("path_route",r -> r.path("/guonei")
        .uri("http://news.baidu.com/guonei")).
                route("path_route",r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
    }
}
