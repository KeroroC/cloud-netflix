package com.keroro.web.service;

import com.keroro.web.feign.DcClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author wangpeng
 * @since 2024年01月24日 21:59
 */
@Service
public class ConsumerService {

    private final DcClient dcClient;

    public ConsumerService(DcClient dcClient) {
        this.dcClient = dcClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String dc() {
        return dcClient.consumer();
    }

    public String fallback() {
        return "fallback";
    }
}
