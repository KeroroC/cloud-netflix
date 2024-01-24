package com.keroro.web.controller;

import com.keroro.web.feign.DcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangpeng
 * @since 2024年01月22日 22:09
 */
@RestController
@RefreshScope
public class ConsumerController {

    private final DcClient dcClient;

    @Value("${info.databasePwd}")
    private String value;

    @Value("${info.name}")
    private String name;

    public ConsumerController(DcClient dcClient) {
        this.dcClient = dcClient;
    }

    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }

    @GetMapping("/pwd")
    public String printConfiguration() {
        return value;
    }

    @GetMapping("/name")
    public String printName() {
        return name;
    }
}
