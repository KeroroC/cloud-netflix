package com.keroro;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 注解@SpringCloudApplication包含了@SpringBootApplication，@EnableDiscoveryClient，@EnableCircuitBreaker
 * 这也意味着一个Spring Cloud标准应用应包含服务发现以及断路器
 */
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@SpringCloudApplication
public class EurekaConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
}